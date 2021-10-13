package com.alkemy.project.demo.serviceImpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alkemy.project.demo.dto.PeliculaDto;
import com.alkemy.project.demo.dto.PeliculaDtoBasic;
import com.alkemy.project.demo.dto.PeliculaFiltersDTO;
import com.alkemy.project.demo.entity.PeliculaEntity;
import com.alkemy.project.demo.entity.PersonajeEntity;
import com.alkemy.project.demo.mapper.PeliculaMapper;
import com.alkemy.project.demo.repository.PeliculaRepository;
import com.alkemy.project.demo.repository.specifications.PeliculaSpecifications;
import com.alkemy.project.demo.service.PeliculaService;
import com.alkemy.project.demo.service.PersonajeService;

@Service
public class PeliculaServiceImpl implements PeliculaService {
	
	@Autowired
	private PeliculaRepository peliRepo;
	@Autowired
	private PeliculaMapper peliMapper;
	@Autowired 
	private PersonajeService perSer;
	@Autowired
	private PeliculaSpecifications peliSpec;
	
	@Override
	@Transactional(readOnly = true)
	public PeliculaEntity getById(Long id) {
		return peliRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public PeliculaDto save(PeliculaEntity pelicula) {
		return peliMapper.peliculaEntity2Dto(peliRepo.save(pelicula));
	}

	@Override
	@Transactional
	public void delete(Long id) {
		peliRepo.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PeliculaDtoBasic> getAll() {
		return peliMapper.peliculaEntity2DtoList(peliRepo.findAll());
	}

	@Override
	@Transactional
	public void addPersonaje(Long idPelicula, Long idPersonaje) {
		PeliculaEntity pel = this.getById(idPelicula);
		PersonajeEntity per = perSer.getById(idPersonaje);
		pel.getPersonajesAsociados().size();
		pel.addPersonaje(per);
		this.save(pel);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PeliculaDtoBasic> getByFilters(String nombre, Set<Long> generos, String order) {
        PeliculaFiltersDTO filtersDTO = new PeliculaFiltersDTO(nombre,generos, order);
        List<PeliculaEntity> entities = this.peliRepo.findAll(this.peliSpec.getByFilters(filtersDTO));
        List<PeliculaDtoBasic> dtos = this.peliMapper.peliculaEntity2DtoList(entities);
        return dtos;
	}

}
