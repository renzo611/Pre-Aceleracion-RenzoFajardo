package com.alkemy.project.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alkemy.project.demo.dto.GeneroDto;
import com.alkemy.project.demo.entity.GeneroEntity;
import com.alkemy.project.demo.entity.PeliculaEntity;
import com.alkemy.project.demo.mapper.GeneroMapper;
import com.alkemy.project.demo.repository.GeneroRepository;
import com.alkemy.project.demo.service.GeneroService;
import com.alkemy.project.demo.service.PeliculaService;

@Service
public class GeneroServiceImpl implements GeneroService {

	@Autowired
	private GeneroRepository genRepo;
	@Autowired
	private GeneroMapper genMap;
	@Autowired
	private PeliculaService peliService;
	
	@Override
	@Transactional
	public GeneroDto save(GeneroEntity genero) {
		return genMap.generoEntity2Dto(genRepo.save(genero));
	}

	@Override
	@Transactional(readOnly = true)
	public List<GeneroDto> getAll() {
		return genMap.generoEntity2Dto(genRepo.findAll());
	}

	@Override
	@Transactional
	public void addPelicula(Long idGenero, Long idPelicula) {
		PeliculaEntity pelicula= peliService.getById(idPelicula);
		GeneroEntity genero = genRepo.getById(idGenero);
		genero.getPeliculasAsociadas().size();
		genero.addPelicula(pelicula);
		this.genRepo.save(genero);
	}
	
	

}
