package com.happy.ControllerAdvice;

import com.happy.Exceptions.ActivityTypeNotFoundException;
import com.happy.Exceptions.ImageNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ImageNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ImageNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String imageTypeNotFoundHandler(ImageNotFoundException ex) {
        return ex.getMessage();
    }
}
