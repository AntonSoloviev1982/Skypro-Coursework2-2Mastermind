package com.example.skyprocoursework22mastermind.repository;


import com.example.skyprocoursework22mastermind.model.Question;

import java.util.Collection;

public interface QuestionRepository {

    public Question add(String question, String answer);

    public Question remove(Question question);

    public Collection<Question> getAll();

}
