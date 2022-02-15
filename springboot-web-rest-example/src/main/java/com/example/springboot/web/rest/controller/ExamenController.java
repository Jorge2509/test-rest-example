package com.example.springboot.web.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.web.rest.entity.Examen;
import com.example.springboot.web.rest.response.GenericResponse;
import com.example.springboot.web.rest.service.ExamenService;

@RestController
@RequestMapping("/api")
public class ExamenController {

	@Autowired
	private ExamenService service;

	@Autowired
	private GenericResponse genericResponse;

	@PostMapping("/crearExamen")
	public ResponseEntity<GenericResponse> createExamen(@RequestBody Examen examen) {
		service.save(examen);

		genericResponse.setCodigo(HttpStatus.OK.name());
		genericResponse.setMensaje(" Examen creado con éxito");

		return new ResponseEntity<GenericResponse>(genericResponse, HttpStatus.OK);

	}

}
