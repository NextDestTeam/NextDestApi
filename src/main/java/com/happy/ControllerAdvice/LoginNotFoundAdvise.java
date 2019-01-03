package com.happy.ControllerAdvice;

import com.happy.Exceptions.LoginNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class LoginNotFoundAdvise {
    @ResponseBody
    @ExceptionHandler(LoginNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String loginNotFoundHandler(LoginNotFoundException ex) {
        return ex.getMessage();
    }
}
