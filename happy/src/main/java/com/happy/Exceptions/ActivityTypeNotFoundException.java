package com.happy.Exceptions;

public class ActivityTypeNotFoundException extends RuntimeException{
    public ActivityTypeNotFoundException(Integer id){
        super("Could not find activity type " + id);
    }
}
