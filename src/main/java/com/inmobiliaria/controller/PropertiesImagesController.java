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
import com.inmobiliaria.model.PropertiesImages;
import com.inmobiliaria.model.ServiceResponse;
import com.inmobiliaria.service.IPropertiesImagesService;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin("*")
public class PropertiesImagesController {

	//Inyectamos el servicio
	@Autowired
	private IPropertiesImagesService iPropertiesImagesService;
	
	//Creamos un método para listar las localizaciones
	@GetMapping("/inmuebles_imagenes")
	public ResponseEntity<List<PropertiesImages>> properties_images(){
		
		var result = iPropertiesImagesService.findAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping("/inmuebles_imagenes")
	public ResponseEntity<ServiceResponse> save(@RequestBody PropertiesImages property_image){
		
		ServiceResponse serviceResponse = new ServiceResponse();
		int result = iPropertiesImagesService.save(property_image);
		
		if(result == 1) {

			serviceResponse.setSuccess(true);
			serviceResponse.setMessage("Property_image added with success");
		}else {
			
			serviceResponse.setSuccess(false);
			serviceResponse.setMessage("Failed to add property_image");
		}
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}
	
	@PutMapping("/inmuebles_imagenes/{id}")
	public ResponseEntity<ServiceResponse> update(@PathVariable("id") int id, @RequestBody PropertiesImages property_image){

		property_image.setId(id);
		ServiceResponse serviceResponse = new ServiceResponse();
		int result = iPropertiesImagesService.update(property_image);
		
		if(result == 1) {

			serviceResponse.setSuccess(true);
			serviceResponse.setMessage("Property_image updated with success");
		}else {
			
			serviceResponse.setSuccess(false);
			serviceResponse.setMessage("Failed to update property_image");
		}
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}
	
	@DeleteMapping("/inmuebles_imagenes/{id}")
	public ResponseEntity<ServiceResponse> update(@PathVariable int id){
		
		ServiceResponse serviceResponse = new ServiceResponse();
		int result = iPropertiesImagesService.deleteById(id);
		
		if(result == 1) {

			serviceResponse.setSuccess(true);
			serviceResponse.setMessage("Property_image removed with success");
		}else {
			
			serviceResponse.setSuccess(false);
			serviceResponse.setMessage("Failed to remove property_image");
		}
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}
}
