package com.happy.ControllerAdvice;

import com.happy.Exceptions.ReactionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ReactionNotFoundAdvise {
    @ResponseBody
    @ExceptionHandler(ReactionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String reactionNotFoundHandler(ReactionNotFoundException ex) {
        return ex.getMessage();
    }
}
