package com.alkemy.project.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alkemy.project.demo.dto.PeliculaDtoBasic;
import com.alkemy.project.demo.entity.PeliculaEntity;

@Component
public class PeliculaMapper {
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
}
