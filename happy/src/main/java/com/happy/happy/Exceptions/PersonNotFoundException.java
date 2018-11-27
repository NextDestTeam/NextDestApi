package com.happy.happy.Exceptions;

public class PersonNotFoundException extends RuntimeException{
    public PersonNotFoundException(Integer id){
        super("Could not find person " + id);
    }
}
