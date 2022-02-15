package com.example.springboot.web.rest.entity;

import javax.persistence.*;

@Entity
@Table(name="opciones")
public class Opcion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer idOpcion;
	
	private String descripcion;
	
	private String codigo;
	
	@Column(name = "opcion_correcta")
	private boolean opcionCorrecta;
	
	public Integer getIdOpcion() {
		return idOpcion;
	}
	public void setIdOpcion(Integer idOpcion) {
		this.idOpcion = idOpcion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isOpcionCorrecta() {
		return opcionCorrecta;
	}
	public void setOpcionCorrecta(boolean opcionCorrecta) {
		this.opcionCorrecta = opcionCorrecta;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	

}
