package com.CompanyName.ProjectName.app.service;

import com.CompanyName.ProjectName.app.model.Book;

public interface BookServicei {

	Book getdatabyid(Integer i);

 public String postdata(Book b);

public Iterable<Book> getdata();

String update(Book b, Integer bookId);

public String delete(Book b);



}
