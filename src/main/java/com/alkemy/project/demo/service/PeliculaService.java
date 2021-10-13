package com.alkemy.project.demo.service;

import java.util.List;
import java.util.Set;

import com.alkemy.project.demo.dto.GeneroDto;
import com.alkemy.project.demo.dto.PeliculaDto;
import com.alkemy.project.demo.dto.PeliculaDtoBasic;
import com.alkemy.project.demo.entity.PeliculaEntity;

public interface PeliculaService {
	public PeliculaEntity getById(Long id);
	public PeliculaDto save(PeliculaEntity pelicula);
	public void delete(Long id);
	public List<PeliculaDtoBasic> getAll();
	public void addPersonaje(Long idPelicula, Long idPersonaje);
	public List<PeliculaDtoBasic> getByFilters(String nombre, Set<Long> generos, String order);
}
