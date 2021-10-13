package com.alkemy.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.project.demo.dto.GeneroDto;
import com.alkemy.project.demo.entity.GeneroEntity;
import com.alkemy.project.demo.service.GeneroService;

@RestController
@RequestMapping("/generos")
public class GeneroController {
	@Autowired
	private GeneroService genSer;
	
	@GetMapping
	public ResponseEntity<List<GeneroDto>> getAll(){
		return ResponseEntity.ok().body(genSer.getAll());
	}
	
	@PostMapping
	public ResponseEntity<GeneroDto> save(@RequestBody GeneroEntity genero){
		return ResponseEntity.status(HttpStatus.CREATED).body(genSer.save(genero));
	}
	
	@PostMapping("/{id}/movie/{idPelicula}")
	public ResponseEntity<?> addPelicula(@PathVariable Long id, @PathVariable Long idPelicula){
		this.genSer.addPelicula(id, idPelicula);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
