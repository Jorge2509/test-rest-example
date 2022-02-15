package com.example.springboot.web.rest.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.web.rest.entity.Estudiante;
import com.example.springboot.web.rest.repository.EstudianteRepository;



@Service
public class EstudianteServiceImpl implements EstudianteService{
	
	@Autowired
	private EstudianteRepository repository;

	@Override
	@Transactional
	public void save(Estudiante estudiante) {
		repository.save(estudiante);
	
		
	}

	@Override
	@Transactional
	public Optional<Estudiante> findById(Integer id) {
		Optional<Estudiante>es= repository.findById(id);
		return Optional.of(es.orElseThrow(
			       () -> new IllegalArgumentException("estudiante con el id :" + id + " no existe...")));
	}
	
	


	
	

}
