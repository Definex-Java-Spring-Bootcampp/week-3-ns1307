package com.patika.mainservice.exceptions;

public class ProjectException extends RuntimeException {

    private String message;

    public ProjectException(String message) {
        super(message);
        this.message = message;
    }
}
