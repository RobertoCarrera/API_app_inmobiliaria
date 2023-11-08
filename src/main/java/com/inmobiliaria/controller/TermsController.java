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
import com.inmobiliaria.model.Terms;
import com.inmobiliaria.model.ServiceResponse;
import com.inmobiliaria.service.ITermsService;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin("*")
public class TermsController {

	//Inyectamos el servicio
		@Autowired
		private ITermsService iTermsService;
		
		//Creamos un método para listar las localizaciones
		@GetMapping("/regimenes")
		public ResponseEntity<List<Terms>> terms(){
			
			var result = iTermsService.findAll();
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		
		@PostMapping("/regimenes")
		public ResponseEntity<ServiceResponse> save(@RequestBody Terms term){
			
			ServiceResponse serviceResponse = new ServiceResponse();
			int result = iTermsService.save(term);
			
			if(result == 1) {

				serviceResponse.setSuccess(true);
				serviceResponse.setMessage("Term added with success");
			}else {
				
				serviceResponse.setSuccess(false);
				serviceResponse.setMessage("Failed to add location");
			}
			return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
		}
		
		@PutMapping("/regimenes/{id}")
		public ResponseEntity<ServiceResponse> update(@PathVariable("id") int id, @RequestBody Terms term){

			term.setId(id);
			ServiceResponse serviceResponse = new ServiceResponse();
			int result = iTermsService.update(term);
			
			if(result == 1) {

				serviceResponse.setSuccess(true);
				serviceResponse.setMessage("Term updated with success");
			}else {
				
				serviceResponse.setSuccess(false);
				serviceResponse.setMessage("Failed to update location");
			}
			return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
		}
		
		@DeleteMapping("/regimenes/{id}")
		public ResponseEntity<ServiceResponse> update(@PathVariable int id){
			
			ServiceResponse serviceResponse = new ServiceResponse();
			int result = iTermsService.deleteById(id);
			
			if(result == 1) {

				serviceResponse.setSuccess(true);
				serviceResponse.setMessage("Term removed with success");
			}else {
				
				serviceResponse.setSuccess(false);
				serviceResponse.setMessage("Failed to remove location");
			}
			return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
		}
}
