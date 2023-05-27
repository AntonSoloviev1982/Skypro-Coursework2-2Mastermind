package com.example.skyprocoursework22mastermind.service.impl;

import com.example.skyprocoursework22mastermind.exception.QuestionNotFoundException;
import com.example.skyprocoursework22mastermind.model.Question;
import com.example.skyprocoursework22mastermind.repository.QuestionRepository;
import com.example.skyprocoursework22mastermind.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {

    private final QuestionRepository repository;

    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Question add(String question, String answer) {
        return repository.add(question, answer);
    }

    @Override
    public Question remove(Question question) {
        if (!repository.getAll().contains(question)) {
            throw new QuestionNotFoundException();
        }
        repository.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return repository.getAll();
    }

    @Override
    public Question getRandomQuestion() {

        Random random = new Random();
        int num1 = random.nextInt(10) + 1;
        int num2 = random.nextInt(10) + 1;
        int operator = random.nextInt(4);
        int answer = 0;
        String operatorSymbol = null;

        switch (operator) {
            case 0:
                operatorSymbol = "+";
                answer = num1 + num2;
                break;
            case 1:
                operatorSymbol = "-";
                answer = num1 - num2;
                break;
            case 2:
                operatorSymbol = "*";
                answer = num1 * num2;
                break;
            case 3:
                operatorSymbol = "/";
                answer = num1 / num2;
                break;
        }

        return new Question("Сколько будет " + num1 + " " + operatorSymbol + " " + num2 + "? ",
                "Ответ : " + answer);
    }
}
