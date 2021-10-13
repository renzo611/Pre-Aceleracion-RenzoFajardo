package com.alkemy.project.demo.service;

import java.util.List;

import com.alkemy.project.demo.dto.GeneroDto;
import com.alkemy.project.demo.entity.GeneroEntity;

public interface GeneroService {
	public GeneroDto save(GeneroEntity genero);
	public List<GeneroDto> getAll();
	public void addPelicula(Long idGenero, Long idPelicula);
	
}
