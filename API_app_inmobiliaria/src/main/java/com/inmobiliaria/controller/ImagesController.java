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

import com.inmobiliaria.model.Images;
import com.inmobiliaria.model.ServiceResponse;
import com.inmobiliaria.service.IImagesService;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin("*")
public class ImagesController {

	//Inyectamos el servicio
		@Autowired
		private IImagesService iImagesService;
		
		//Creamos un método para listar las localizaciones
		@GetMapping("/imagenes")
		public ResponseEntity<List<Images>> image(){
			
			var result = iImagesService.findAll();
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		
		@PostMapping("/imagenes")
		public ResponseEntity<ServiceResponse> save(@RequestBody Images image){
			
			ServiceResponse serviceResponse = new ServiceResponse();
			int result = iImagesService.save(image);
			
			if(result == 1) {

				serviceResponse.setSuccess(true);
				serviceResponse.setMessage("Image saved with success");
			}else {
				
				serviceResponse.setSuccess(false);
				serviceResponse.setMessage("Failed to add image");
			}
			return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
		}
		
		@PutMapping("/imagenes/{id}")
		public ResponseEntity<ServiceResponse> update(@PathVariable("id") int id, @RequestBody Images image){

			image.setId(id);
			ServiceResponse serviceResponse = new ServiceResponse();
			int result = iImagesService.update(image);
			
			if(result == 1) {

				serviceResponse.setSuccess(true);
				serviceResponse.setMessage("Image updated with success");
			}else {
				
				serviceResponse.setSuccess(false);
				serviceResponse.setMessage("Failed to update image");
			}
			return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
		}
		
		@DeleteMapping("/imagenes/{id}")
		public ResponseEntity<ServiceResponse> update(@PathVariable int id){
			
			ServiceResponse serviceResponse = new ServiceResponse();
			int result = iImagesService.deleteById(id);
			
			if(result == 1) {

				serviceResponse.setSuccess(true);
				serviceResponse.setMessage("Image removed with success");
			}else {
				
				serviceResponse.setSuccess(false);
				serviceResponse.setMessage("Failed to remove image");
			}
			return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
		}
}
