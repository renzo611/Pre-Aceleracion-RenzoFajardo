package com.alkemy.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alkemy.project.demo.entity.PersonajeEntity;

@Repository
public interface PersonajeRepository extends JpaRepository<PersonajeEntity, Long>{

}
