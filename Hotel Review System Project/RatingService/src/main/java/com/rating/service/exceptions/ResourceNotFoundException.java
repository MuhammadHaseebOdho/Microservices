package com.rating.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException() {
        System.out.println("Sorry, Requested Resource can not be found on server.");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
