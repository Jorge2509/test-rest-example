package com.example.springboot.web.rest.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="examenes")
public class Examen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer idExamen;
	
	@Column(name="codigo_examen")
	private String codigo;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name ="examen_id")
	private List<Pregunta> preguntas;

	public Integer getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(Integer idExamen) {
		this.idExamen = idExamen;
	}

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
		

}
