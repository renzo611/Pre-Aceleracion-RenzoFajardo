package com.alkemy.project.demo.entity;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "pelicula")
public class PeliculaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column
	private String imagen;
	
	@Column
	private String titulo;
	
	@Column
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date fechaCreacion;
	
	@Range(min = 1,max = 5)
	private int calificacion;
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			})
			@JoinTable(
						name = "pelicula_personaje",
						joinColumns = @JoinColumn(name = "pelicula_id"),
						inverseJoinColumns  = @JoinColumn(name = "personaje_id")
			)
	private List<PersonajeEntity> personajesAsociados = new ArrayList<>();

	@ManyToMany(mappedBy = "peliculasAsociadas")
	private List<GeneroEntity> generosAsociados = new ArrayList<>(); 
	
	@PrePersist
	private void init() {
		this.fechaCreacion = new Date();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<PersonajeEntity> getPersonajesAsociados() {
		return personajesAsociados;
	}

	public void setPersonajesAsociados(List<PersonajeEntity> personajesAsociados) {
		this.personajesAsociados = personajesAsociados;
	}

	public List<GeneroEntity> getGenerosAsociados() {
		return generosAsociados;
	}

	public void setGenerosAsociados(List<GeneroEntity> generosAsociados) {
		this.generosAsociados = generosAsociados;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public void addPersonaje(PersonajeEntity personaje) {
		this.personajesAsociados.add(personaje);
	}
	
}
