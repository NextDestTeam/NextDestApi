package com.happy.Exceptions;

public class ReactionNotFoundException extends RuntimeException {
    public ReactionNotFoundException(Integer id){
        super("Could not find reaction " + id);
    }
}
