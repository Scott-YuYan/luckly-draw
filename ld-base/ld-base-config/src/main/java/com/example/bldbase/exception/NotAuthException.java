package com.example.bldbase.exception;

/**
 * 鉴权失败异常
 */
public class NotAuthException extends RuntimeException {

    public NotAuthException() {
    }

    public NotAuthException(String message, Object... args) {
        super(String.format(message, args));
    }

    public NotAuthException(String message, Throwable cause, Object... args) {
        super(String.format(message, args), cause);
    }

    public NotAuthException(Throwable cause) {
        super(cause);
    }
}
