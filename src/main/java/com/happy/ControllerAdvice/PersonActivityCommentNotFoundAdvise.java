package com.happy.ControllerAdvice;

import com.happy.Exceptions.PersonActivityCommentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class PersonActivityCommentNotFoundAdvise {
    @ResponseBody
    @ExceptionHandler(PersonActivityCommentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String commentNotFoundHandler(PersonActivityCommentNotFoundException ex) {
        return ex.getMessage();
    }
}
