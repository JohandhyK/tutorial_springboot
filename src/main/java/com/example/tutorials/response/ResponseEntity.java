package com.example.tutorials.response;

public class ResponseEntity <T> {

    private boolean success;
    private String message;
    private T data;

    public ResponseEntity(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
	
}
