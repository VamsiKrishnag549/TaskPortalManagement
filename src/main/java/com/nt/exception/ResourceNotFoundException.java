package com.nt.exception;

//public class ResourceNotFoundException {
//
//}

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
