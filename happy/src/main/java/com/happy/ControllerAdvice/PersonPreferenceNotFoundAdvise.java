package com.happy.ControllerAdvice;

import com.happy.Exceptions.PersonPreferenceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class PersonPreferenceNotFoundAdvise {
    @ResponseBody
    @ExceptionHandler(PersonPreferenceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String personPreferenceNotFoundHandler(PersonPreferenceNotFoundException ex) {
        return ex.getMessage();
    }
}
