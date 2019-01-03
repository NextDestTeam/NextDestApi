package com.happy.Exceptions;

public class LoginNotFoundException extends RuntimeException{
    public LoginNotFoundException(Integer id){
        super("Could not find login " + id);
    }
}
