package com.microservice.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.main.model.Producer;
import com.microservice.main.service.Servicep;

@RestController
@RequestMapping("/api")
public class Controller {

	@Autowired
	private Servicep servicepl;
	
	@PostMapping("/producer")
	public ResponseEntity<Producer> postdata(@RequestBody Producer producer) {
		
		return new ResponseEntity<Producer>(servicepl.postdata(producer),HttpStatus.CREATED);
				
	}
	@GetMapping("/producer")
	public ResponseEntity<Iterable<Producer>> getdata(){
		
		return new ResponseEntity<Iterable<Producer>>(servicepl.getdata(),HttpStatus.OK);
	}
	@PutMapping("/producer/{id}")
	public ResponseEntity<String> update(@RequestBody Producer producer,@PathVariable("id")Integer id) {
		
		return new ResponseEntity<String>(servicepl.updateData(producer,id),HttpStatus.OK);
				
	}
	@DeleteMapping("/producer/{id}")
	public ResponseEntity<String> Delete(@PathVariable("id")Integer id) {
		
		return new ResponseEntity<String>(servicepl.deleteData(id),HttpStatus.OK);
				
	}
	
	
}
