package com.alkemy.project.demo.dto;

import java.util.List;

public class PersonajeDto {
	private Long id;
	private String imagen;
	private String nombre;
	private Long edad;
	private float peso;
	private String historia;
	private List<PeliculaDtoBasic> peliculasAsociadas;
	
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getEdad() {
		return edad;
	}
	public void setEdad(Long edad) {
		this.edad = edad;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public String getHistoria() {
		return historia;
	}
	public void setHistoria(String historia) {
		this.historia = historia;
	}
	public List<PeliculaDtoBasic> getPeliculasAsociadas() {
		return peliculasAsociadas;
	}
	public void setPeliculasAsociadas(List<PeliculaDtoBasic> peliculasAsociadas) {
		this.peliculasAsociadas = peliculasAsociadas;
	}
	
	
}
