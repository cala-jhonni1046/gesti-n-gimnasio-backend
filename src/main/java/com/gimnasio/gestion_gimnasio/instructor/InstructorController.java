package com.gimnasio.gestion_gimnasio.instructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstructorController {

	@Autowired
	private InstructorService service;
	
	// Recuperar todos
	@GetMapping("/instructores")
	public ResponseEntity<List<Instructor>> buscarInstructor(){
	
			List<Instructor> listaInstructor = service.getAll();
			if(listaInstructor.isEmpty()) {
				return ResponseEntity.noContent().build();
			} else {
				return ResponseEntity.ok(listaInstructor);
				
			}
			
	}
	
	// Recuperar una sola
	@GetMapping("/instructores/{id}")
	public ResponseEntity<Instructor> buscarInstructorPorID(@PathVariable Long id) {
	
		Instructor instructor = service.getById(id);
		if (instructor == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(instructor);
		}
	}
	
	//Crear nuevo instructor
	@PostMapping("/instructores")
	public ResponseEntity <Instructor> crearNuevoInstructor(@RequestBody Instructor instructor){
		try {
			Instructor instructorCreado = service.create(instructor);
			return ResponseEntity.ok(instructorCreado);
		} catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	// Eliminar membresia
	@DeleteMapping("/instructores/id")
	public ResponseEntity<?> borrarInstructoresPorId(@PathVariable Long id) {
		Instructor instructor =service.getById(id);
		if (instructor == null) {
			return ResponseEntity.notFound().build();
		}else {
			service.delete(id);
			return ResponseEntity.ok().build();
		}
	}
	
	
	
	
}







