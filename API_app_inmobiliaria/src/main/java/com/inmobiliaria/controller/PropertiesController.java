package com.inmobiliaria.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.inmobiliaria.model.Properties;
import com.inmobiliaria.model.ServiceResponse;
import com.inmobiliaria.service.IPropertiesService;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin("*")
public class PropertiesController {

	//Inyectamos el servicio
	@Autowired
	private IPropertiesService iPropertiesService;
	
	//Creamos un método para listar los inmuebles
	@GetMapping("/inmuebles")
	public ResponseEntity<List<Properties>> propertys(){
		
		var result = iPropertiesService.findAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping("/inmuebles")
	public ResponseEntity<ServiceResponse> save(@RequestBody Properties property){
		
		ServiceResponse serviceResponse = new ServiceResponse();
		int result = iPropertiesService.save(property);
		
		if(result == 1) {

			serviceResponse.setSuccess(true);
			serviceResponse.setMessage("Property saved with success");
		}else {
			
			serviceResponse.setSuccess(false);
			serviceResponse.setMessage("Failed to add location");
		}
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}
	
	@PutMapping("/inmuebles/{id}")
	public ResponseEntity<ServiceResponse> update(@PathVariable("id") int id, @RequestBody Properties property){

		property.setId(id);
		ServiceResponse serviceResponse = new ServiceResponse();
		int result = iPropertiesService.update(property);
		
		if(result == 1) {

			serviceResponse.setSuccess(true);
			serviceResponse.setMessage("Property updated with success");
		}else {
			
			serviceResponse.setSuccess(false);
			serviceResponse.setMessage("Failed to update location");
		}
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}
	
	@DeleteMapping("/inmuebles/{id}")
	public ResponseEntity<ServiceResponse> update(@PathVariable int id){
		
		ServiceResponse serviceResponse = new ServiceResponse();
		int result = iPropertiesService.deleteById(id);
		
		if(result == 1) {

			serviceResponse.setSuccess(true);
			serviceResponse.setMessage("Property removed with success");
		}else {
			
			serviceResponse.setSuccess(false);
			serviceResponse.setMessage("Failed to remove location");
		}
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}
}
