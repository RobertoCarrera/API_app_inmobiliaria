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
import com.inmobiliaria.model.Characteristics;
import com.inmobiliaria.model.ServiceResponse;
import com.inmobiliaria.service.ICharacteristicsService;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin("*")
public class CharacteristicsController {

	//Inyectamos el servicio
		@Autowired
		private ICharacteristicsService iCharacteristicsService;
		
		//Creamos un método para listar las localizaciones
		@GetMapping("/caracteristicas")
		public ResponseEntity<List<Characteristics>> characteristics(){
			
			var result = iCharacteristicsService.findAll();
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		
		@PostMapping("/caracteristicas")
		public ResponseEntity<ServiceResponse> save(@RequestBody Characteristics characteristic){
			
			ServiceResponse serviceResponse = new ServiceResponse();
			int result = iCharacteristicsService.save(characteristic);
			
			if(result == 1) {

				serviceResponse.setSuccess(true);
				serviceResponse.setMessage("Characteristic saved with success");
			}else {
				
				serviceResponse.setSuccess(false);
				serviceResponse.setMessage("Failed to add location");
			}
			return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
		}
		
		@PutMapping("/caracteristicas/{id}")
		public ResponseEntity<ServiceResponse> update(@PathVariable("id") int id, @RequestBody Characteristics characteristic){

			characteristic.setId(id);
			ServiceResponse serviceResponse = new ServiceResponse();
			int result = iCharacteristicsService.update(characteristic);
			
			if(result == 1) {

				serviceResponse.setSuccess(true);
				serviceResponse.setMessage("Characteristic updated with success");
			}else {
				
				serviceResponse.setSuccess(false);
				serviceResponse.setMessage("Failed to update location");
			}
			return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
		}
		
		@DeleteMapping("/caracteristicas/{id}")
		public ResponseEntity<ServiceResponse> update(@PathVariable int id){
			
			ServiceResponse serviceResponse = new ServiceResponse();
			int result = iCharacteristicsService.deleteById(id);
			
			if(result == 1) {

				serviceResponse.setSuccess(true);
				serviceResponse.setMessage("Characteristic removed with success");
			}else {
				
				serviceResponse.setSuccess(false);
				serviceResponse.setMessage("Failed to remove location");
			}
			return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
		}
}
