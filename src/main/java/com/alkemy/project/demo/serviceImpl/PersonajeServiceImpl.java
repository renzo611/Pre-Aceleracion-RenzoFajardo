package com.alkemy.project.demo.serviceImpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alkemy.project.demo.dto.PersonajeDto;
import com.alkemy.project.demo.dto.PersonajeDtoBasic;
import com.alkemy.project.demo.dto.PersonajeDtoFilters;
import com.alkemy.project.demo.entity.PersonajeEntity;
import com.alkemy.project.demo.mapper.PersonajeMapper;
import com.alkemy.project.demo.repository.PersonajeRepository;
import com.alkemy.project.demo.repository.specifications.PersonajeSpecifications;
import com.alkemy.project.demo.service.PersonajeService;

@Service
public class PersonajeServiceImpl implements PersonajeService{
	
	@Autowired
	private PersonajeRepository personajeRepo;
	@Autowired
	private PersonajeMapper personajeMap;
	@Autowired
	private PersonajeSpecifications persoSpec;
	
	@Override
	@Transactional(readOnly = true)
	public List<PersonajeDtoBasic> getAll() {
		return personajeMap.personajeEntity2DtoList(personajeRepo.findAll());
	}

	@Override
	@Transactional
	public PersonajeDto save(PersonajeEntity entity) {
		return personajeMap.personajeEntity2Dto(personajeRepo.save(entity));
	}

	@Override
	@Transactional(readOnly = true)
	public PersonajeEntity getById(Long id) {
		return personajeRepo.getById(id);
	}

	@Override
	public void delete(Long id) {
		personajeRepo.deleteById(id);
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public List<PersonajeDtoBasic> getByFilters(String nombre, Long edad, Set<Long> peliculas) {
		PersonajeDtoFilters filtersDTO = new PersonajeDtoFilters(nombre,edad, peliculas);
        List<PersonajeEntity> entities = this.personajeRepo.findAll(this.persoSpec.getByFilters(filtersDTO));
        List<PersonajeDtoBasic> dtos = this.personajeMap.personajeEntity2DtoList(entities);
        return dtos;
	}
	
}
