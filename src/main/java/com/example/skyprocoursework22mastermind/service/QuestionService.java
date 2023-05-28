package com.example.skyprocoursework22mastermind.service;


import com.example.skyprocoursework22mastermind.model.Question;

import java.util.Collection;

public interface QuestionService {

    public Question add(String question, String answer);

    public Question remove(Question question);

    public Collection<Question> getAll();

    public Question getRandomQuestion();

}
