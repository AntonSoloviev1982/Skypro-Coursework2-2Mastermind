package com.example.skyprocoursework22mastermind.handler;

import com.example.skyprocoursework22mastermind.exception.QuestionIllegalArgumentException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExaminerServiceImplHandler {

    @ExceptionHandler(QuestionIllegalArgumentException.class)
    public String getQuestionsWhenAmountMoreWhenSetQuestionSizeException() {
        return "Количество запрашиваемых вопросов превышает количества вопросов в хранилище";
    }

}
