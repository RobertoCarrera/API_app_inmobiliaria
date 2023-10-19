package com.inmobiliaria.model;

import lombok.Data;

//Con esta clase responderemos a las consultas con un mensaje de success o error
@Data
public class ServiceResponse {

	Boolean success;
	String message;
	public void setSuccess(boolean b) {
		// TODO Auto-generated method stub
		
	}
	public void setMessage(String string) {
		// TODO Auto-generated method stub
		
	}
}
