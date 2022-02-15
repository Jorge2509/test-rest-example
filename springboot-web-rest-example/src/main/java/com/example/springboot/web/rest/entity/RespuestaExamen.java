package com.example.springboot.web.rest.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "respuesta_examen")
public class RespuestaExamen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "registroexamen_id")
	private RegistroExamen asignacionExamen;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "respuestaexamen_id")
	private List<Respuesta> respuestas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RegistroExamen getAsignacionExamen() {
		return asignacionExamen;
	}

	public void setAsignacionExamen(RegistroExamen asignacionExamen) {
		this.asignacionExamen = asignacionExamen;
	}

	public List<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

}
