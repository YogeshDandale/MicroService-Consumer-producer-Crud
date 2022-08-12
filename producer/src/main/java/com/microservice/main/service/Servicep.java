package com.microservice.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.main.model.Producer;
import com.microservice.main.repository.Repositoryp;

@Service
public class Servicep {

	@Autowired
	private Repositoryp repositoryp;

	public Producer postdata(Producer producer) {
		Producer save = repositoryp.save(producer);
		return save;
	}

	public Iterable<Producer> getdata() {
		Iterable<Producer> l=repositoryp.findAll();
		return l;
	}

	public String updateData(Producer producer, Integer id) {
		producer.setId(id);
		repositoryp.save(producer);
		
		return "Update Data SuccessFully";
	}

	public String deleteData(Integer id) {
		repositoryp.deleteById(id);
		return "Delete Data SuccessFully";
	}
}
