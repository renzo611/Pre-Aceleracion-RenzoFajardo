package com.alkemy.project.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alkemy.project.demo.dto.GeneroDto;
import com.alkemy.project.demo.dto.GeneroDtoBasic;
import com.alkemy.project.demo.dto.PeliculaDtoBasic;
import com.alkemy.project.demo.entity.GeneroEntity;
import com.alkemy.project.demo.entity.PeliculaEntity;

@Component
public class GeneroMapper {
	
	@Autowired
	private PeliculaMapper peliMap;
	
	public List<GeneroDto> generoEntity2Dto(List<GeneroEntity> generos){
		List<GeneroDto> dtos = new ArrayList<>();
		for (GeneroEntity genero : generos) {
			dtos.add(this.generoEntity2Dto(genero));
		}
		return dtos;
	}

	public GeneroDto generoEntity2Dto(GeneroEntity genero) {
		GeneroDto gen = new GeneroDto();
		gen.setId(genero.getId());
		gen.setImagen(genero.getImagen());
		gen.setNombre(genero.getNombre());
		List<PeliculaDtoBasic> pelis = new ArrayList<>();
		for (PeliculaEntity pelicula : genero.getPeliculasAsociadas()) {
			pelis.add(peliMap.peliculaEntity2DtoBasic(pelicula));
		}
		gen.setPeliculasAsociadas(pelis);
		return gen;
	}
	
	public GeneroDtoBasic generoEntity2DtoBasic(GeneroEntity genero) {
		GeneroDtoBasic gen = new GeneroDtoBasic();
		gen.setId(genero.getId());
		gen.setImagen(genero.getImagen());
		gen.setNombre(genero.getNombre());
		return gen;
	}
}
