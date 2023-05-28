package com.example.skyprocoursework22mastermind.service.impl;

import com.example.skyprocoursework22mastermind.exception.QuestionNotFoundException;
import com.example.skyprocoursework22mastermind.model.Question;
import com.example.skyprocoursework22mastermind.repository.QuestionRepository;
import com.example.skyprocoursework22mastermind.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {

    private final QuestionRepository repository;

    public JavaQuestionService(@Qualifier("javaQuestionRepository") QuestionRepository repository) {
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
        int questionIndex = random.nextInt(repository.getAll().size());
        List<Question> questionsWithIndex = new ArrayList<>(repository.getAll());
        return questionsWithIndex.get(questionIndex);
    }
}
