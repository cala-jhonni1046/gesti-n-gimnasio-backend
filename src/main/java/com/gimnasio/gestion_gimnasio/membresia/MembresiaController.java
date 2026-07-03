package com.gimnasio.gestion_gimnasio.membresia;

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
public class MembresiaController {
	
	@Autowired
	private MembresiaService service;
	
	// Recuperar todas
		@GetMapping("/membresias")
		public ResponseEntity<List<Membresia>> buscarMembresia(){
			
			List<Membresia> listaMembresia = service.getAll();
			
			if (listaMembresia.isEmpty()) {
				return ResponseEntity.noContent().build();
			} else {
				return ResponseEntity.ok(listaMembresia);
			}
			
		}
		
		// Recuperar una sola
		@GetMapping("/membresias/{id}")
		public ResponseEntity<Membresia> buscarMembresiaPorId(@PathVariable Long id) {
			
			Membresia membresia = service.getById(id);
			if (membresia == null) {
				return ResponseEntity.notFound().build();
			} else {
				return ResponseEntity.ok(membresia);
			}
		}
		
		// Crear nueva membresia
		@PostMapping("/membresias")
		public ResponseEntity<Membresia> crearNuevamembresia(@RequestBody Membresia membresia) {
			try {
				Membresia membresiaCreada = service.create(membresia);
				return ResponseEntity.ok(membresiaCreada);
			}catch(Exception e) {
				return ResponseEntity.badRequest().build();
			}
		}
		
		// Actualizar la membresia
		@PutMapping("/membresias/{id}")
		public ResponseEntity<Membresia> actualizarMembresia(@PathVariable Long id, @RequestBody Membresia membresia) {
			Membresia membresiaDesdeServicio = service.getById(id);
			if (membresiaDesdeServicio == null) {
				return ResponseEntity.notFound().build();
			} else {
				try {
					Membresia membresiaActualizada = service.update(membresia, id);
					return ResponseEntity.ok(membresiaActualizada);
				}catch(Exception e) {
					return ResponseEntity.badRequest().build();
				}
			}
		}
		
		// Eliminar membresia
		@DeleteMapping("/membresias/{id}")
		public ResponseEntity<?> borrarMembresiaPorId(@PathVariable Long id) {
			
			Membresia membresia = service.getById(id);
			if (membresia == null) {
				return ResponseEntity.notFound().build();
			} else {
				service.delete(id);
				return ResponseEntity.ok().build();
			}
		}

}
