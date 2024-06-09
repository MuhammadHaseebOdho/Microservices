package com.hotel.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException() {
        super("Requested Resource can not be found.");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
