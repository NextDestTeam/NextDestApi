package com.happy.Exceptions;

public class ActivityNotFoundException extends RuntimeException{
    public ActivityNotFoundException(Integer id){
        super("Could not find activity " + id);
    }
}
