package com.example.taxibookingapplication.exception;

public class UserNameAlreadyPresentException extends Throwable {
    public UserNameAlreadyPresentException(String message) {
        super(message);
    }
}
