package com.example.bldbase.exception;

public class BldException extends RuntimeException {

    public BldException() {
    }

    public BldException(String message, Object... args) {
        super(String.format(message, args));
    }

    public BldException(String message, Throwable cause, Object... args) {
        super(String.format(message, args), cause);
    }

    public BldException(Throwable cause) {
        super(cause);
    }

}
