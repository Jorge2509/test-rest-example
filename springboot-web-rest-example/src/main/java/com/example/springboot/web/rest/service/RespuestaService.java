package com.example.springboot.web.rest.service;


import com.example.springboot.web.rest.entity.RegistroExamen;
import com.example.springboot.web.rest.entity.RespuestaExamen;

public interface RespuestaService {
	
	
	public void save(RespuestaExamen respuesta);
	
	public Double calcularPuntaje(RegistroExamen registroExamen);

}
