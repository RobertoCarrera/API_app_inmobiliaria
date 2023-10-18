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
import com.inmobiliaria.model.Categories;
import com.inmobiliaria.model.ServiceResponse;
import com.inmobiliaria.service.ICategoriesService;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin("*")
public class CategoriesController {

	//Inyectamos el servicio
	@Autowired
	private ICategoriesService iCategoriesService;
	
	//Creamos un método para listar las localizaciones
	@GetMapping("/tipos_casa")
	public ResponseEntity<List<Categories>> categories(){
		
		var result = iCategoriesService.findAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping("/tipos_casa")
	public ResponseEntity<ServiceResponse> save(@RequestBody Categories category){
		
		ServiceResponse serviceResponse = new ServiceResponse();
		int result = iCategoriesService.save(category);
		
		if(result == 1) {

			serviceResponse.setSuccess(true);
			serviceResponse.setMessage("Category saved with success");
		}else {
			
			serviceResponse.setSuccess(false);
			serviceResponse.setMessage("Failed to add location");
		}
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}
	
	@PutMapping("/tipos_casa/{id}")
	public ResponseEntity<ServiceResponse> update(@PathVariable("id") int id, @RequestBody Categories category){

		category.setId(id);
		ServiceResponse serviceResponse = new ServiceResponse();
		int result = iCategoriesService.update(category);
		
		if(result == 1) {

			serviceResponse.setSuccess(true);
			serviceResponse.setMessage("Category updated with success");
		}else {
			
			serviceResponse.setSuccess(false);
			serviceResponse.setMessage("Failed to update location");
		}
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}
	
	@DeleteMapping("/tipos_casa/{id}")
	public ResponseEntity<ServiceResponse> update(@PathVariable int id){
		
		ServiceResponse serviceResponse = new ServiceResponse();
		int result = iCategoriesService.deleteById(id);
		
		if(result == 1) {

			serviceResponse.setSuccess(true);
			serviceResponse.setMessage("Category removed with success");
		}else {
			
			serviceResponse.setSuccess(false);
			serviceResponse.setMessage("Failed to remove location");
		}
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}
}
