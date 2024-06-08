package com.user.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(){
        super("Requested Resource Can not be found on server");
    }
    public ResourceNotFoundException(String message){
        super(message);
    }
}
