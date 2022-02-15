package com.example.springboot.web.rest.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.web.rest.entity.Estudiante;
import com.example.springboot.web.rest.entity.Examen;
import com.example.springboot.web.rest.entity.RegistroExamen;
import com.example.springboot.web.rest.entity.RespuestaExamen;
import com.example.springboot.web.rest.response.GenericResponse;
import com.example.springboot.web.rest.service.EstudianteService;
import com.example.springboot.web.rest.service.ExamenService;
import com.example.springboot.web.rest.service.RegistroExamenService;
import com.example.springboot.web.rest.service.RespuestaService;

@RestController
@RequestMapping("/api")
public class RegistroExamenController {

	@Autowired
	private RegistroExamenService service;

	@Autowired
	private ExamenService examenService;

	@Autowired
	private EstudianteService estudianteService;

	@Autowired
	private RespuestaService respuestaService;

	@Autowired
	private GenericResponse genericResponse;
	
	private static Logger log= LoggerFactory.getLogger(RegistroExamenController.class);

	@PostMapping("/registroExamen")
	public ResponseEntity<GenericResponse> registro(@RequestBody RegistroExamen registro) {
		HttpStatus httpStatus;
		try {
			Examen examen = examenService.findByforId(registro.getExamen().getIdExamen());
			Optional<Estudiante> estudiante = estudianteService.findById(registro.getEstudiante().getId());

			if (estudiante.isPresent()) {
				registro.setEstudiante(estudiante.get());
				registro.setExamen(examen);
				String respuesta = service.save(registro);
				genericResponse.setCodigo(HttpStatus.OK.name());
				genericResponse.setMensaje(
						"Examen Asignado  con éxito debe presentar el examen en la fecha ".concat(respuesta));
				httpStatus = HttpStatus.OK;
			} else {
				genericResponse.setCodigo(HttpStatus.NOT_FOUND.name());
				genericResponse.setMensaje("error al asignar el examen");
				httpStatus = HttpStatus.NOT_FOUND;

			}
		} catch (Exception e) {
			genericResponse.setCodigo(HttpStatus.NOT_FOUND.name());
			genericResponse.setMensaje("error al asignar el examen:" + e);
			log.error("error al asignar el examen:"+e);
			httpStatus = HttpStatus.NOT_FOUND;
		}

		return new ResponseEntity<GenericResponse>(genericResponse, httpStatus);

	}

	@PostMapping("/registroRespuestas")
	public ResponseEntity<GenericResponse> guardarReespuesta(@RequestBody RespuestaExamen respuesta) {
		respuestaService.save(respuesta);
		Double puntaje = respuestaService.calcularPuntaje(respuesta.getAsignacionExamen());

		genericResponse.setCodigo(HttpStatus.OK.name());
		genericResponse.setMensaje("Su puntaje es: ".concat(puntaje.toString()).concat("/100.0 "));

		return new ResponseEntity<GenericResponse>(genericResponse, HttpStatus.OK);

	}

}
