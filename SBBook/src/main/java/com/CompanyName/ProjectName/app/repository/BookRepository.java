package com.CompanyName.ProjectName.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CompanyName.ProjectName.app.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
