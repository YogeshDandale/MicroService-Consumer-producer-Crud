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
import org.springframework.web.client.RestTemplate;

import com.microservice.main.model.Consume;


@RestController
@RequestMapping("/api")
public class Controllers {

	@Autowired
	RestTemplate rt;
	
	@PostMapping("/consumer")
	public ResponseEntity<Consume> postData(@RequestBody Consume consume) {
		String url="http://zuul/pro/api/producer";
		Consume object = rt.postForObject(url, consume,Consume.class);
		
		return new ResponseEntity<Consume>(object,HttpStatus.CREATED);
	}
	@GetMapping("/consumer")
	public ResponseEntity<Iterable<Consume>> getdata(){
		String url="http://zuul/pro/api/producer";
		Iterable object = rt.getForObject(url,Iterable.class);
		return new ResponseEntity<Iterable<Consume>>(object,HttpStatus.OK);
	}
	
	@PutMapping("/consumer/{id}")
	public ResponseEntity<String> updateData(@RequestBody Consume consume,@PathVariable("id") Integer id){
		String url="http://zuul/pro/api/producer/"+id+"";
		//String url = "http://localhost:9091/api/product/" + i + "";
		rt.put(url,consume,String.class);
		return new ResponseEntity<String>("Update Success Fully",HttpStatus.OK);
	}
	
	@DeleteMapping("/consumer/{id}")
	public ResponseEntity<String> deleteData(@PathVariable("id") Integer id){
		String url="http://zuul/pro/api/producer/"+id+"";
		//String url = "http://localhost:9091/api/product/" + i + "";
		rt.delete(url,String.class);
		return new ResponseEntity<String>("Delete Success Fully",HttpStatus.NO_CONTENT);
	}
}
