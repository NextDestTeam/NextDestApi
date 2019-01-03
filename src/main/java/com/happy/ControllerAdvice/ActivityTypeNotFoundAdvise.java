package com.happy.ControllerAdvice;

import com.happy.Exceptions.ActivityTypeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ActivityTypeNotFoundAdvise {
    @ResponseBody
    @ExceptionHandler(ActivityTypeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String activityTypeNotFoundHandler(ActivityTypeNotFoundException ex) {
        return ex.getMessage();
    }
}
