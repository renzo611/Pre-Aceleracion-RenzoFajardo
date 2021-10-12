package com.alkemy.project.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alkemy.project.demo.dto.PersonajeDto;
import com.alkemy.project.demo.dto.PersonajeDtoBasic;
import com.alkemy.project.demo.entity.PersonajeEntity;

@Component
public class PersonajeMapper {
	
	@Autowired
	private PeliculaMapper peliMap;
	
	public List<PersonajeDtoBasic> personajeEntity2DtoList(List<PersonajeEntity> personajes){
		List<PersonajeDtoBasic> personajesDto = new ArrayList<>();
		for (PersonajeEntity personaje : personajes) {
			personajesDto.add(this.personajeEntity2DtoBasic(personaje));
		}
		return personajesDto;
	}
	
	public PersonajeDtoBasic personajeEntity2DtoBasic(PersonajeEntity entity) {
		PersonajeDtoBasic personaje = new PersonajeDtoBasic();
		personaje.setId(entity.getId());
		personaje.setImagen(entity.getImagen());
		personaje.setNombre(entity.getNombre());
		return personaje;
	}
	
	public PersonajeDto personajeEntity2Dto(PersonajeEntity entity) {
		PersonajeDto personaje = new PersonajeDto();
		personaje.setEdad(entity.getEdad());
		personaje.setHistoria(entity.getHistoria());
		personaje.setId(entity.getId());
		personaje.setImagen(entity.getImagen());
		personaje.setNombre(entity.getNombre());
		personaje.setPeso(entity.getPeso());
		personaje.setPeliculasAsociadas(peliMap.peliculaEntity2DtoList(entity.getPeliculasAsociadas()));
		return personaje;
	}
	
}
