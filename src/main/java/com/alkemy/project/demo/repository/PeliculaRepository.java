package com.alkemy.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.alkemy.project.demo.entity.PeliculaEntity;

@Repository
public interface PeliculaRepository extends JpaRepository<PeliculaEntity,Long>,JpaSpecificationExecutor<PeliculaEntity>{

}
