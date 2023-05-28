package com.example.skyprocoursework22mastermind.handler;


import com.example.skyprocoursework22mastermind.exception.MethodMathQuestionNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class MathQuestionServiceHandler {

    @ExceptionHandler(MethodMathQuestionNotFoundException.class)
    public String mathMethodsNotFoundException() {
        return "Method math is not allowed";
    }
}
