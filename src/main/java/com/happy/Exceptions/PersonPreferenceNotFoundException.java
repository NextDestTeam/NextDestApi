package com.happy.Exceptions;

public class PersonPreferenceNotFoundException extends RuntimeException {
    public PersonPreferenceNotFoundException(Integer id){
        super("Could not find person preference " + id);
    }
}
