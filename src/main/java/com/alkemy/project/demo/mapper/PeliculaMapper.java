package com.alkemy.project.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alkemy.project.demo.dto.GeneroDtoBasic;
import com.alkemy.project.demo.dto.PeliculaDto;
import com.alkemy.project.demo.dto.PeliculaDtoBasic;
import com.alkemy.project.demo.dto.PersonajeDtoBasic;
import com.alkemy.project.demo.entity.GeneroEntity;
import com.alkemy.project.demo.entity.PeliculaEntity;
import com.alkemy.project.demo.entity.PersonajeEntity;

@Component
public class PeliculaMapper {
	
	@Autowired
	private GeneroMapper genMap;
	@Autowired
	private PersonajeMapper perMap;
	public List<PeliculaDtoBasic> peliculaEntity2DtoList(List<PeliculaEntity> peliculas){
		List<PeliculaDtoBasic> peliculasDto = new ArrayList<>();
		for (PeliculaEntity pelicula : peliculas) {
			peliculasDto.add(this.peliculaEntity2DtoBasic(pelicula));
		}
		return peliculasDto;
	}
	
	public PeliculaDtoBasic peliculaEntity2DtoBasic(PeliculaEntity pelicula) {
		PeliculaDtoBasic newPeli = new PeliculaDtoBasic();
		newPeli.setFechaCreacion(pelicula.getFechaCreacion());
		newPeli.setId(pelicula.getId());
		newPeli.setImagen(pelicula.getImagen());
		newPeli.setTitulo(pelicula.getTitulo());
		return newPeli;
	}

	public PeliculaDto peliculaEntity2Dto(PeliculaEntity entity) {
		PeliculaDto pelicula = new PeliculaDto();
		pelicula.setCalificacion(entity.getCalificacion());
		pelicula.setFechaCreacion(entity.getFechaCreacion());
		pelicula.setId(entity.getId());
		pelicula.setImagen(entity.getImagen());
		pelicula.setTitulo(entity.getTitulo());
		List<PersonajeDtoBasic> personajes = new ArrayList<>();
		for (PersonajeEntity personaje: entity.getPersonajesAsociados()) {
			personajes.add(perMap.personajeEntity2DtoBasic(personaje));
		}
		List<GeneroDtoBasic> generos = new ArrayList<>();
		for (GeneroEntity genero : entity.getGenerosAsociados()) {
			generos.add(genMap.generoEntity2DtoBasic(genero));
		}
		pelicula.setPersonajesAsociados(personajes);
		pelicula.setGenerosAsociados(generos);
		return pelicula;
	}
}
