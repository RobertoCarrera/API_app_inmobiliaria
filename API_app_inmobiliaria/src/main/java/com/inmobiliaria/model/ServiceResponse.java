package com.inmobiliaria.model;

import lombok.Data;

//Con esta clase responderemos a las consultas con un mensaje de success o error
@Data
public class ServiceResponse {

	Boolean success;
	String message;
}
