package com.example.springboot.web.rest.service;

import com.example.springboot.web.rest.entity.Examen;


public interface ExamenService {
	
	public void save(Examen examen);
	
	public Examen findByforId(Integer id);
	

}
