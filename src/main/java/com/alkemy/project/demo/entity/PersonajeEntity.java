package com.alkemy.project.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "personaje")
public class PersonajeEntity {
	@NotEmpty
	private String imagen;
	
	@NotEmpty
	private String nombre;
	
	@NotNull
	private Long edad;
	
	@NotNull
	private float peso;
	
	@NotNull
	private String historia;
	
}
