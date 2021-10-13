package com.alkemy.project.demo.dto;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

public class PeliculaDto {
	private Long id;
	private String imagen;
	private String titulo;
	private Date fechaCreacion;
	private int calificacion;
	private List<PersonajeDtoBasic> personajesAsociados = new ArrayList<>();
	private List<GeneroDtoBasic> generosAsociados = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public int getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	public List<PersonajeDtoBasic> getPersonajesAsociados() {
		return personajesAsociados;
	}
	public void setPersonajesAsociados(List<PersonajeDtoBasic> personajesAsociados) {
		this.personajesAsociados = personajesAsociados;
	}
	public List<GeneroDtoBasic> getGenerosAsociados() {
		return generosAsociados;
	}
	public void setGenerosAsociados(List<GeneroDtoBasic> generosAsociados) {
		this.generosAsociados = generosAsociados;
	}
	
	
}
