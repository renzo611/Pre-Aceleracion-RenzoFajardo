package com.alkemy.project.demo.dto;

import java.util.ArrayList;

import java.util.List;


public class GeneroDto {
	private Long id;
	private String nombre;
	private String imagen;
	private List<PeliculaDtoBasic> peliculasAsociadas = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public List<PeliculaDtoBasic> getPeliculasAsociadas() {
		return peliculasAsociadas;
	}
	public void setPeliculasAsociadas(List<PeliculaDtoBasic> peliculasAsociadas) {
		this.peliculasAsociadas = peliculasAsociadas;
	}
	
	
}
