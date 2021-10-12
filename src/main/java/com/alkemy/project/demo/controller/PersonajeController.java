package com.alkemy.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.project.demo.dto.PersonajeDtoBasic;
import com.alkemy.project.demo.entity.PersonajeEntity;
import com.alkemy.project.demo.service.PersonajeService;

@RestController
@RequestMapping("/characters")
public class PersonajeController {
	@Autowired 
	private PersonajeService personajeService;
	
	
	@GetMapping
	public ResponseEntity<List<PersonajeDtoBasic>> getPersonajes(){
		return ResponseEntity.ok().body(personajeService.getAll());
	}
	
	@PostMapping
	public ResponseEntity<?> savePersonaje(@RequestBody PersonajeEntity personaje){
		return ResponseEntity.status(HttpStatus.CREATED).body(personajeService.save(personaje));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updatePersonaje(@PathVariable Long id, @RequestBody PersonajeEntity entity){
		PersonajeEntity personaje = personajeService.getById(id);
		if(personaje != null) {
			personaje.setEdad(entity.getEdad());
			personaje.setHistoria(entity.getHistoria());
			personaje.setId(entity.getId());
			personaje.setImagen(entity.getImagen());
			personaje.setNombre(entity.getNombre());
			personaje.setPeso(entity.getPeso());
			return ResponseEntity.ok().body(personajeService.save(personaje));
		}
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePersonaje(@PathVariable Long id){
		PersonajeEntity pj = personajeService.getById(id);
		if(pj != null) {
			personajeService.delete(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
}
