package com.happy.Exceptions;

public class PersonActivityCommentNotFoundException extends RuntimeException{
    public PersonActivityCommentNotFoundException(Integer id){
        super("Could not find comment " + id);
    }
}
