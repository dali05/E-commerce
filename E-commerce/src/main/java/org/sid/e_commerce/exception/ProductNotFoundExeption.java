package org.sid.e_commerce.exception;

import java.io.Serializable;

public class ProductNotFoundExeption extends Exception implements Serializable {
	private String message;
	
	public ProductNotFoundExeption(){
		this("product is not available");
	}
	public ProductNotFoundExeption(String message){
		this.message= System.currentTimeMillis()+": " + message;
	}
	public String getMessage() {
		return message;
	}
	
	
}
