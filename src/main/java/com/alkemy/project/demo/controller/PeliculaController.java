package com.alkemy.project.demo.controller;
import java.util.List;
import java.util.Set;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alkemy.project.demo.dto.PeliculaDto;
import com.alkemy.project.demo.dto.PeliculaDtoBasic;
import com.alkemy.project.demo.entity.PeliculaEntity;
import com.alkemy.project.demo.mapper.PeliculaMapper;
import com.alkemy.project.demo.service.PeliculaService;

@RestController
@RequestMapping("/movies")
public class PeliculaController {
	@Autowired
	private PeliculaService peliService;
	@Autowired
	private PeliculaMapper peliMap;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<PeliculaDtoBasic>> getAll(){
		return ResponseEntity.ok().body(peliService.getAll());
	}
	
	@PostMapping
	public ResponseEntity<PeliculaDto> savePelicula(@RequestBody PeliculaEntity pelicula){
		return ResponseEntity.status(HttpStatus.CREATED).body(peliService.save(pelicula));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PeliculaDto> updatePelicula(@PathVariable Long id, @RequestBody PeliculaEntity entity){
		PeliculaEntity pelicula = peliService.getById(id);
		if(pelicula != null) {
			pelicula.setCalificacion(entity.getCalificacion());
			pelicula.setFechaCreacion(entity.getFechaCreacion());
			pelicula.setImagen(entity.getImagen());
			pelicula.setTitulo(entity.getTitulo());
			return ResponseEntity.ok().body(peliService.save(pelicula));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePelicula(@PathVariable Long id){
		PeliculaEntity pelicula = peliService.getById(id);
		if(pelicula != null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		PeliculaEntity pelicula = peliService.getById(id);
		if(pelicula != null) {
			return ResponseEntity.ok().body(peliMap.peliculaEntity2Dto(pelicula));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@PostMapping("/{id}/characters/{idPersonaje}")
	public ResponseEntity<?> addPersonaje(@PathVariable Long id,@PathVariable Long idPersonaje){
		peliService.addPersonaje(id, idPersonaje);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping
    public ResponseEntity<?> getDetailsByFilters(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) Set<Long> generos,
            @RequestParam(required = false, defaultValue = "ASC") String order
    ) {
        List<PeliculaDtoBasic> icons = this.peliService.getByFilters(nombre, generos, order);
        return ResponseEntity.ok(icons);
    }
}
