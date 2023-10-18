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
import com.inmobiliaria.model.PropertiesCharacteristics;
import com.inmobiliaria.model.ServiceResponse;
import com.inmobiliaria.service.IPropertiesCharacteristicsService;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin("*")
public class PropertiesCharacteristicsController {

	//Inyectamos el servicio
		@Autowired
		private IPropertiesCharacteristicsService iPropertiesCharacteristicsService;
		
		//Creamos un método para listar las localizaciones
		@GetMapping("/inmuebles_caracteristicas")
		public ResponseEntity<List<PropertiesCharacteristics>> property_characteristicss(){
			
			var result = iPropertiesCharacteristicsService.findAll();
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		
		@PostMapping("/inmuebles_caracteristicas")
		public ResponseEntity<ServiceResponse> save(@RequestBody PropertiesCharacteristics property_characteristics){
			
			ServiceResponse serviceResponse = new ServiceResponse();
			int result = iPropertiesCharacteristicsService.save(property_characteristics);
			
			if(result == 1) {

				serviceResponse.setSuccess(true);
				serviceResponse.setMessage("PropertyCharacteristic saved with success");
			}else {
				
				serviceResponse.setSuccess(false);
				serviceResponse.setMessage("Failed to add location");
			}
			return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
		}
		
		@PutMapping("/inmuebles_caracteristicas/{id}")
		public ResponseEntity<ServiceResponse> update(@PathVariable("id") int id, @RequestBody PropertiesCharacteristics property_characteristics){

			property_characteristics.setId(id);
			ServiceResponse serviceResponse = new ServiceResponse();
			int result = iPropertiesCharacteristicsService.update(property_characteristics);
			
			if(result == 1) {

				serviceResponse.setSuccess(true);
				serviceResponse.setMessage("PropertyCharacteristic updated with success");
			}else {
				
				serviceResponse.setSuccess(false);
				serviceResponse.setMessage("Failed to update location");
			}
			return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
		}
		
		@DeleteMapping("/inmuebles_caracteristicas/{id}")
		public ResponseEntity<ServiceResponse> update(@PathVariable int id){
			
			ServiceResponse serviceResponse = new ServiceResponse();
			int result = iPropertiesCharacteristicsService.deleteById(id);
			
			if(result == 1) {

				serviceResponse.setSuccess(true);
				serviceResponse.setMessage("PropertyCharacteristic removed with success");
			}else {
				
				serviceResponse.setSuccess(false);
				serviceResponse.setMessage("Failed to remove location");
			}
			return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
		}
}
