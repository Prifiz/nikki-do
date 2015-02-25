package com.myhomeapps.nikkido.exceptions;

public class HandleableException extends RuntimeException {
    public HandleableException(final String message){
        super(message);
    }

    public HandleableException(final Throwable cause) {
        super(cause);
    }

    public HandleableException(String message, Throwable cause) {
        super(message, cause);
    }
}
