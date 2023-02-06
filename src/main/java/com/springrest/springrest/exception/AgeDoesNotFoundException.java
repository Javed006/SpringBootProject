package com.springrest.springrest.exception;

public class AgeDoesNotFoundException extends Exception {
    public AgeDoesNotFoundException(String InvalidAge) {
        super(InvalidAge);

    }
}
