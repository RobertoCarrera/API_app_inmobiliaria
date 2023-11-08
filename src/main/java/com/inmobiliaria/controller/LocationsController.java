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
import com.inmobiliaria.model.Locations;
import com.inmobiliaria.model.ServiceResponse;
import com.inmobiliaria.service.ILocationsService;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin("*")
public class LocationsController {

	//Inyectamos el servicio
	@Autowired
	private ILocationsService iLocationsService;
	
	//Creamos un método para listar las localizaciones
	@GetMapping("/poblaciones")
	public ResponseEntity<List<Locations>> locations(){
		
		var result = iLocationsService.findAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping("/poblaciones")
	public ResponseEntity<ServiceResponse> save(@RequestBody Locations location){
		
		ServiceResponse serviceResponse = new ServiceResponse();
		int result = iLocationsService.save(location);
		
		if(result == 1) {

			serviceResponse.setSuccess(true);
			serviceResponse.setMessage("Location saved with success");
		}else {
			
			serviceResponse.setSuccess(false);
			serviceResponse.setMessage("Failed to add location");
		}
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}
	
	@PutMapping("/poblaciones/{id}")
	public ResponseEntity<ServiceResponse> update(@PathVariable("id") int id, @RequestBody Locations location){
		
		location.setId(id);
		ServiceResponse serviceResponse = new ServiceResponse();
		int result = iLocationsService.update(location);
		
		if(result == 1) {

			serviceResponse.setSuccess(true);
			serviceResponse.setMessage("Location updated with success");
		}else {
			
			serviceResponse.setSuccess(false);
			serviceResponse.setMessage("Failed to update location");
		}
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}
	
	@DeleteMapping("/poblaciones/{id}")
	public ResponseEntity<ServiceResponse> update(@PathVariable int id){
		
		ServiceResponse serviceResponse = new ServiceResponse();
		int result = iLocationsService.deleteById(id);
		
		if(result == 1) {

			serviceResponse.setSuccess(true);
			serviceResponse.setMessage("Location removed with success");
		}else {
			
			serviceResponse.setSuccess(false);
			serviceResponse.setMessage("Failed to remove location");
		}
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}
}