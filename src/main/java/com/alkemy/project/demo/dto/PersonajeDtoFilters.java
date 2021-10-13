package com.alkemy.project.demo.dto;

import java.util.Set;
public class PersonajeDtoFilters {
	private String nombre;
	private Long edad;
	private Set<Long> peliculas;
	
	public PersonajeDtoFilters(String nombre, Long edad, Set<Long> peliculas) {
		this.nombre = nombre;
		this.edad = edad;
		this.peliculas = peliculas;
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
	public Set<Long> getPeliculas() {
		return peliculas;
	}
	public void setPeliculas(Set<Long> peliculas) {
		this.peliculas = peliculas;
	}
	
}
