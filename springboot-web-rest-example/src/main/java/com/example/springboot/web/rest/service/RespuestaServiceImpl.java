package com.example.springboot.web.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.web.rest.entity.RegistroExamen;
import com.example.springboot.web.rest.entity.RespuestaExamen;
import com.example.springboot.web.rest.repository.RespuestaRepository;

@Service
public class RespuestaServiceImpl implements RespuestaService {
	

	@Autowired
	private RespuestaRepository repository;
	
	@Override
	public void save(RespuestaExamen respuesta) {
		repository.save(respuesta);
	}


	@Override
	public Double calcularPuntaje(RegistroExamen registroExamen) {
		Double puntaje = repository.calcularPuntajeExamen(registroExamen.getEstudiante().getId(), registroExamen.getExamen().getIdExamen());
		return puntaje;
	}
	
	

}
