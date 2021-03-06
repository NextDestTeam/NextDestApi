package com.happy.ControllerAdvice;

import com.happy.Exceptions.PersonTypeNorFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class PersonTypeNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(PersonTypeNorFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String personTypeNotFoundHandler(PersonTypeNorFoundException ex) {
        return ex.getMessage();
    }
}
