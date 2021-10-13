package com.alkemy.project.demo.dto;

import java.util.Set;

public class PeliculaFiltersDTO {
	private String nombre;
	private Set<Long> generos;
	private String order;
	
	public PeliculaFiltersDTO(String nombre, Set<Long> generos, String order) {
		this.nombre = nombre;
		this.generos = generos;
		this.order = order;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Long> getGeneros() {
		return generos;
	}

	public void setGeneros(Set<Long> generos) {
		this.generos = generos;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public boolean isASC() {
        return this.order.compareToIgnoreCase("ASC") == 0;
    }

    public boolean isDESC() {
        return this.order.compareToIgnoreCase("DESC") == 0;
    }
}
