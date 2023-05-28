package com.example.skyprocoursework22mastermind.service.impl;

import com.example.skyprocoursework22mastermind.exception.QuestionIllegalArgumentException;
import com.example.skyprocoursework22mastermind.model.Question;
import com.example.skyprocoursework22mastermind.repository.impl.JavaQuestionRepository;
import com.example.skyprocoursework22mastermind.service.ExaminerService;
import com.example.skyprocoursework22mastermind.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {


    private List<QuestionService> questionServices;

    @Autowired
    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.questionServices = new ArrayList<>();
        this.questionServices.add(javaQuestionService);
        this.questionServices.add(mathQuestionService);
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> randomQuestions = new HashSet<>();
        Random random = new Random();
        while (randomQuestions.size() < amount) {
            int questionRandom = random.nextInt(2);
            switch (questionRandom) {
                case 0:
                    randomQuestions.add(questionServices.get(0).getRandomQuestion());
                    break;
                case 1:
                    randomQuestions.add(questionServices.get(1).getRandomQuestion());
                    break;
            }
        }
        return randomQuestions;
    }
}
