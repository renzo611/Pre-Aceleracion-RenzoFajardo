package com.alkemy.project.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "personaje")
public class PersonajeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column
	private String imagen;
	
	@Column
	private String nombre;
	
	@Column
	private Long edad;
	
	@Column
	private float peso;
	
	@Column
	private String historia;
	
	@ManyToMany(mappedBy = "personajesAsociados")
	private List<PeliculaEntity> peliculasAso = new ArrayList<>();
	
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

	public List<PeliculaEntity> getPeliculasAsociadas() {
		return peliculasAso;
	}

	public void setPeliculasAsociadas(List<PeliculaEntity> peliculasAsociadas) {
		this.peliculasAso = peliculasAsociadas;
	}
	
	
}
