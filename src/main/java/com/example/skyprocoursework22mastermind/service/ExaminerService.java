package com.example.skyprocoursework22mastermind.service;


import com.example.skyprocoursework22mastermind.model.Question;

import java.util.Collection;

public interface ExaminerService {

    public Collection<Question> getQuestions(int amount);

}
