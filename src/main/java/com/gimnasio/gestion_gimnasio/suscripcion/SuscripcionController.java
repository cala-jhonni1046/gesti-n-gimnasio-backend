package com.gimnasio.gestion_gimnasio.suscripcion;

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
public class SuscripcionController {
	
	@Autowired
	private SuscripcionService service;
	
	// Recuperar todas
		@GetMapping("/suscrpciones")
		public ResponseEntity<List<Suscripcion>> buscarSuscripcion(){
			
			List<Suscripcion> listaSuscripcion = service.getAll();
			
			if (listaSuscripcion.isEmpty()) {
				return ResponseEntity.noContent().build();
			} else {
				return ResponseEntity.ok(listaSuscripcion);
			}
			
		}
		
		// Recuperar una sola
		@GetMapping("/suscripciones/{id}")
		public ResponseEntity<Suscripcion> buscarSuscripcionPorId(@PathVariable Long id) {
			
			Suscripcion suscripcion = service.getById(id);
			if (suscripcion == null) {
				return ResponseEntity.notFound().build();
			} else {
				return ResponseEntity.ok(suscripcion);
			}
		}
		
		// Crear nueva suscripcion
		@PostMapping("/suscripciones")
		public ResponseEntity<Suscripcion> crearNuevaSuscripcion(@RequestBody Suscripcion suscripcion) {
			try {
				Suscripcion suscripcionCreada = service.create(suscripcion);
				return ResponseEntity.ok(suscripcionCreada);
			}catch(Exception e) {
				return ResponseEntity.badRequest().build();
			}
		}
		
		// Actualizar la suscripcion
		@PutMapping("/suscripciones/{id}")
		public ResponseEntity<Suscripcion> actualizarSuscripcion(@PathVariable Long id, @RequestBody Suscripcion suscripcion) {
			Suscripcion suscripcionDesdeServicio = service.getById(id);
			if (suscripcionDesdeServicio == null) {
				return ResponseEntity.notFound().build();
			} else {
				try {
					Suscripcion suscripcionActualizada = service.update(suscripcion, id);
					return ResponseEntity.ok(suscripcionActualizada);
				}catch(Exception e) {
					return ResponseEntity.badRequest().build();
				}
			}
		}
		
		// Eliminar suscripcion
		@DeleteMapping("/suscripciones/{id}")
		public ResponseEntity<?> borrarSuscripcionPorId(@PathVariable Long id) {
			
			Suscripcion suscripcion = service.getById(id);
			if (suscripcion == null) {
				return ResponseEntity.notFound().build();
			} else {
				service.delete(id);
				return ResponseEntity.ok().build();
			}
		}

}
