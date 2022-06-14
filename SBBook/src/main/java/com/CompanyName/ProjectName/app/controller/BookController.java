package com.CompanyName.ProjectName.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.CompanyName.ProjectName.app.model.Book;
import com.CompanyName.ProjectName.app.service.BookServicei;


@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
	BookServicei bsi;
	
	@PostMapping("/book")
	public ResponseEntity<String> savedata(@RequestBody Book b){
		
		return new ResponseEntity<String>(bsi.postdata(b),HttpStatus.CREATED);
	}
	@GetMapping("/book")
	public ResponseEntity<Iterable<Book>> getedata(){
		return new ResponseEntity<Iterable<Book>>(bsi.getdata(),HttpStatus.OK);
		
	}
	@PutMapping("/book/{bookId}")
	public ResponseEntity<String> update(@RequestBody Book b,@PathVariable Integer bookId ){
		
		return new ResponseEntity<String>(bsi.update(b,bookId),HttpStatus.OK);
	}
	@DeleteMapping("/book/{bookId}")
	public ResponseEntity<String> delete(@PathVariable Integer bookId){
		
		return new ResponseEntity<String>(bsi.delete(bookId),HttpStatus.OK);
	}
	
	@GetMapping("/book/{bookId}")
	public ResponseEntity<Book> getdata(@PathVariable("bookId") Integer i){
		return new ResponseEntity<Book>(bsi.getdatabyid(i),HttpStatus.OK);
	}
}
