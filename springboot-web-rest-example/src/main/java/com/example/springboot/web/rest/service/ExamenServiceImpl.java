package com.example.springboot.web.rest.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.web.rest.entity.Examen;
import com.example.springboot.web.rest.repository.ExamenRepository;


@Service
public class ExamenServiceImpl implements ExamenService {
	
	@Autowired
	private ExamenRepository repository;

	@Override
	@Transactional
	public void save(Examen examen) {
		repository.save(examen);
		
	}

	@Override
	public Examen findByforId(Integer id) {
		Examen examen= repository.getById(id);
		return examen;
	}

}
