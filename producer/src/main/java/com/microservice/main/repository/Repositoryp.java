package com.microservice.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.main.model.Producer;

@Repository
public interface Repositoryp extends JpaRepository<Producer, Integer> {

}
