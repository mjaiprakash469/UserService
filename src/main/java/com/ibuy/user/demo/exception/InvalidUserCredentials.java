package com.ibuy.user.demo.exception;

public class InvalidUserCredentials extends RuntimeException{
	private static final long serialVersionUID = 1L;
	    public InvalidUserCredentials(String message){
	        super(message);
	    }
}
