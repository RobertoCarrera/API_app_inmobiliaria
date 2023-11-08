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
import com.inmobiliaria.model.Owners;
import com.inmobiliaria.model.ServiceResponse;
import com.inmobiliaria.service.IOwnersService;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin("*")
public class OwnersController {

	//Inyectamos el servicio
	@Autowired
	private IOwnersService iOwnersService;
	
	//Creamos un método para listar los propietarios
	@GetMapping("/propietarios")
	public ResponseEntity<List<Owners>> owners(){
		
		var result = iOwnersService.findAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping("/propietarios")
	public ResponseEntity<ServiceResponse> save(@RequestBody Owners owner){
		
		ServiceResponse serviceResponse = new ServiceResponse();
		int result = iOwnersService.save(owner);
		
		if(result == 1) {

			serviceResponse.setSuccess(true);
			serviceResponse.setMessage("Owner saved with success");
		}else {
			
			serviceResponse.setSuccess(false);
			serviceResponse.setMessage("Failed to add location");
		}
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}
	
	@PutMapping("/propietarios/{id}")
	public ResponseEntity<ServiceResponse> update(@PathVariable("id") int id, @RequestBody Owners owner){

		owner.setId(id);
		ServiceResponse serviceResponse = new ServiceResponse();
		int result = iOwnersService.update(owner);
		
		if(result == 1) {

			serviceResponse.setSuccess(true);
			serviceResponse.setMessage("Owner updated with success");
		}else {
			
			serviceResponse.setSuccess(false);
			serviceResponse.setMessage("Failed to update location");
		}
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}
	
	@DeleteMapping("/propietarios/{id}")
	public ResponseEntity<ServiceResponse> update(@PathVariable int id){
		
		ServiceResponse serviceResponse = new ServiceResponse();
		int result = iOwnersService.deleteById(id);
		
		if(result == 1) {

			serviceResponse.setSuccess(true);
			serviceResponse.setMessage("Owner removed with success");
		}else {
			
			serviceResponse.setSuccess(false);
			serviceResponse.setMessage("Failed to delete location");
		}
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}
}
