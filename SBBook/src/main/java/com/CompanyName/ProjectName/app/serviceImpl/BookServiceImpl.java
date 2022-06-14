package com.CompanyName.ProjectName.app.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CompanyName.ProjectName.app.model.Book;
import com.CompanyName.ProjectName.app.repository.BookRepository;
import com.CompanyName.ProjectName.app.service.BookServicei;

@Service
public class BookServiceImpl implements BookServicei {

	@Autowired
	BookRepository br;

	
	@Override
	public Book getdatabyid(Integer i) {
		Optional<Book> id = br.findById(i);
		if(id.isPresent()) {
			 Book book = id.get();
			return book;
		}
		else {
			new ArithmeticException("Id Is Not Present");
		}
		return null;
		
	}


	@Override
	public String postdata(Book b) {
		 br.save(b);
		
		return "Data Created in data base";
	}


	@Override
	public Iterable<Book> getdata() {
		
		return br.findAll();
	}


	@Override
	public String update(Book b, Integer bookId) {
		b.setBookId(bookId);
		br.save(b);
		return "update data";
	}


	@Override
	public String delete(Book b) {
		br.delete(b);
		return "delete data";
	}
}
