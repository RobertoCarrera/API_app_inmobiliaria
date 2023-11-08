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
import com.inmobiliaria.model.CharacteristicGroups;
import com.inmobiliaria.model.ServiceResponse;
import com.inmobiliaria.service.ICharacteristicGroupsService;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin("*")
public class CharacteristicGroupsController {

	//Inyectamos el servicio
	@Autowired
	private ICharacteristicGroupsService iCharacteristicGroupsService;
	
	//Creamos un método para listar las localizaciones
	@GetMapping("/grupos")
	public ResponseEntity<List<CharacteristicGroups>> groups(){
		
		var result = iCharacteristicGroupsService.findAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping("/grupos")
	public ResponseEntity<ServiceResponse> save(@RequestBody CharacteristicGroups group){
		
		ServiceResponse serviceResponse = new ServiceResponse();
		int result = iCharacteristicGroupsService.save(group);
		
		if(result == 1) {

			serviceResponse.setSuccess(true);
			serviceResponse.setMessage("Group saved with success");
		}else {
			
			serviceResponse.setSuccess(false);
			serviceResponse.setMessage("Failed to add group");
		}
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}
	
	@PutMapping("/grupos/{id}")
	public ResponseEntity<ServiceResponse> update(@PathVariable("id") int id, @RequestBody CharacteristicGroups group){

		group.setId(id);
		ServiceResponse serviceResponse = new ServiceResponse();
		int result = iCharacteristicGroupsService.update(group);
		
		if(result == 1) {

			serviceResponse.setSuccess(true);
			serviceResponse.setMessage("Group updated with success");
		}else {
			
			serviceResponse.setSuccess(false);
			serviceResponse.setMessage("Failed to update location");
		}
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}
	
	@DeleteMapping("/grupos/{id}")
	public ResponseEntity<ServiceResponse> update(@PathVariable int id){
		
		ServiceResponse serviceResponse = new ServiceResponse();
		int result = iCharacteristicGroupsService.deleteById(id);
		
		if(result == 1) {

			serviceResponse.setSuccess(true);
			serviceResponse.setMessage("Group removed with success");
		}else {
			
			serviceResponse.setSuccess(false);
			serviceResponse.setMessage("Failed to remove location");
		}
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}
}
