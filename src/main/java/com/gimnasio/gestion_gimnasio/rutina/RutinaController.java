package com.gimnasio.gestion_gimnasio.rutina;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RutinaController {
	
	@Autowired
	private RutinaService service;
	
	// Recuperar todas
		@GetMapping("/rutinas")
		public ResponseEntity<List<Rutina>> buscarRutina(){
			
			List<Rutina> listaRutina = service.getAll();
			
			if (listaRutina.isEmpty()) {
				return ResponseEntity.noContent().build();
			} else {
				return ResponseEntity.ok(listaRutina);
			}
			
		}
		
		// Recuperar una sola
		@GetMapping("/rutinas/{id}")
		public ResponseEntity<Rutina> buscarRutinaPorId(@PathVariable Long id) {
			
			Rutina rutina = service.getById(id);
			if (rutina == null) {
				return ResponseEntity.notFound().build();
			} else {
				return ResponseEntity.ok(rutina);
			}
		}
		
		// Crear nueva rutina
		@PostMapping("/rutinas")
		public ResponseEntity<Rutina> crearNuevaRutina(@RequestBody Rutina rutina) {
			try {
				Rutina rutinaCreada = service.create(rutina);
				return ResponseEntity.ok(rutinaCreada);
			}catch(Exception e) {
				return ResponseEntity.badRequest().build();
			}
		}
		
		// Actualizar la rutina
		@PutMapping("/rutinas/{id}")
		public ResponseEntity<Rutina> actualizarRutina(@PathVariable Long id, @RequestBody Rutina rutina) {
			Rutina rutinaDesdeServicio = service.getById(id);
			if (rutinaDesdeServicio == null) {
				return ResponseEntity.notFound().build();
			} else {
				try {
					Rutina rutinaActualizada = service.update(rutina, id);
					return ResponseEntity.ok(rutinaActualizada);
				}catch(Exception e) {
					return ResponseEntity.badRequest().build();
				}
			}
		}
		
		// Eliminar rutina
		@DeleteMapping("/rutinas/{id}")
		public ResponseEntity<?> borrarRutinaPorId(@PathVariable Long id) {
			
			Rutina rutina = service.getById(id);
			if (rutina == null) {
				return ResponseEntity.notFound().build();
			} else {
				service.delete(id);
				return ResponseEntity.ok().build();
			}
		}

}
