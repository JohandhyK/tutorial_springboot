package com.example.tutorials.response;

import com.example.tutorials.entity.LecturerSubjectsEntity;

public class ResponseEntity <T> {

    private boolean success;
    private String message;
    private T data;

    public ResponseEntity(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
    
    public ResponseEntity() {
    	
    }
    
//    public ResponseEntity<LecturerSubjectsEntity> getData(boolean success, String message){
//    	  this.success = success;
//          this.message = message;
//    }
    
//    public void getData(boolean success, String message, T data){
//    	this.success = success;
//        this.message = message;
//        this.data = data;
//    }


    public boolean isSuccess(boolean isSuccess) {
        return success;
    }

    public String getMessage(String string) {
        return message;
    }

    public T getData() {
        return data;
    }
	
}
