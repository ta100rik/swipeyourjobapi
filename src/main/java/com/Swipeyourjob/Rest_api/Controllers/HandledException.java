package com.Swipeyourjob.Rest_api.Controllers;

public class HandledException extends Exception {
    private int code;

    public HandledException(int code, String message) {
        super(message);
        this.setCode(code);
    }

    public HandledException(int code, String message, Throwable cause) {
        super(message, cause);
        this.setCode(code);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
