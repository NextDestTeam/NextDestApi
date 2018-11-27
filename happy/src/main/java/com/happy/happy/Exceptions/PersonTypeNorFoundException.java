package com.happy.happy.Exceptions;

public class PersonTypeNorFoundException extends RuntimeException {
    public PersonTypeNorFoundException(Integer id){
        super("Could not find person type " + id);
    }
}
