package com.example.spring.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UnauthorizedException.class)
    public String handleUnauthorizationError(Model model, Exception exception) {
        model.addAttribute("exception", exception);
        return "error";
    }
}