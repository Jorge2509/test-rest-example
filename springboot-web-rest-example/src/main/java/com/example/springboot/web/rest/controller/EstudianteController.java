package com.example.springboot.web.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.web.rest.entity.Estudiante;
import com.example.springboot.web.rest.response.GenericResponse;
import com.example.springboot.web.rest.service.EstudianteService;


@RestController
@RequestMapping("/api")
public class EstudianteController {
	
	@Autowired
	private EstudianteService service;
	
	@Autowired
	private GenericResponse genericResponse;
	
	
	@PostMapping("/crearEstudiante")
	public ResponseEntity<GenericResponse> crearEstudiante(@RequestBody Estudiante estudiante){
		service.save(estudiante);
		genericResponse.setCodigo(HttpStatus.OK.name());
		genericResponse.setMensaje( "Estudiante creado con éxito");
		

		return new ResponseEntity<GenericResponse>(genericResponse,
				HttpStatus.OK);	
	
		
	}

}
