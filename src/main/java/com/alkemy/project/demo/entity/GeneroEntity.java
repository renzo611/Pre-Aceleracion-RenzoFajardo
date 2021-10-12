package com.alkemy.project.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "genero")
public class GeneroEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column
	private String nombre;
	
	@Column
	private String imagen;
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			})
			@JoinTable(
						name = "genero_pelicula",
						joinColumns = @JoinColumn(name = "genero_id"),
						inverseJoinColumns  = @JoinColumn(name = "pelicula_id")
			)
	private List<PeliculaEntity> peliculasAsociadas = new ArrayList<>();

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

	public List<PeliculaEntity> getPeliculasAsociadas() {
		return peliculasAsociadas;
	}

	public void setPeliculasAsociadas(List<PeliculaEntity> peliculasAsociadas) {
		this.peliculasAsociadas = peliculasAsociadas;
	}
	
	
}
