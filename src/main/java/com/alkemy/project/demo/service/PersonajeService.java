package com.alkemy.project.demo.service;

import java.util.List;
import java.util.Optional;

import com.alkemy.project.demo.dto.PersonajeDto;
import com.alkemy.project.demo.dto.PersonajeDtoBasic;
import com.alkemy.project.demo.entity.PersonajeEntity;

public interface PersonajeService{
	public List<PersonajeDtoBasic> getAll();
	public PersonajeDto save(PersonajeEntity entity);
	public PersonajeEntity getById(Long id);
	public void delete(Long id);
}
