package com.happy.Exceptions;

public class ImageNotFoundException extends RuntimeException {
    public ImageNotFoundException(Integer id){
        super("Could not find image " + id);
    }
}
