package com.example.springboot.web.rest.service;



import java.util.Optional;

import com.example.springboot.web.rest.entity.Estudiante;


public interface EstudianteService {
	
	public void save(Estudiante estudiante);
	
	public Optional<Estudiante> findById(Integer id);

}
