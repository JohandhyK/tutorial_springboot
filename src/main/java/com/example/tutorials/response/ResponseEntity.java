package com.example.tutorials.response;

import com.example.tutorials.entity.LecturerSubjectsEntity;

public class ResponseEntity <T> {

	private String Status;
    private String message;
    private T data;
    
    public ResponseEntity() {
    	
    }
    
    public ResponseEntity(String Status, String message){
    	  this.Status = Status;
          this.message = message;
    }
    
    public ResponseEntity(String status, String message, T data) {
    	this.Status = status;
        this.message = message;
        this.data = data;
    }
    
//    public ResponseEntity(Boolean status, String message, T data) {
//    	this.message = message;
//        this.data = data;
//    }
    
    public String getStatus() {
		return Status;
	}

	public ResponseEntity<T> setStatus(String Status) {
		this.Status = Status;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public ResponseEntity<T> setMessage(String message) {
		this.message = message;
		return this;
	}

	public ResponseEntity<T> setData(T data) {
		this.data = data;
		return this;
	}

    public T getData() {
        return data;
    }	
}
