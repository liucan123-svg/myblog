package com.xsh.handler;


public class StateErrorException extends Exception {
    public StateErrorException() {
        super();
    }

    public StateErrorException(String message) {
        super(message);
    }

    public StateErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public StateErrorException(Throwable cause) {
        super(cause);
    }

    protected StateErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
