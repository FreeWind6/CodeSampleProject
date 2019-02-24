package com.javalesson.exceptions;

public class InvalidInputParamExceprion extends RuntimeException {

    public InvalidInputParamExceprion() {
    }

    public InvalidInputParamExceprion(String message) {
        super(message);
    }

    public InvalidInputParamExceprion(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidInputParamExceprion(Throwable cause) {
        super(cause);
    }
}
