package com.gimnasio.gestion_gimnasio.equipo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EquipoController {
	
	@Autowired
	private EquipoService service;
	
		// Recuperar todos los equipos
		@GetMapping ("/equipos")
		public ResponseEntity< List<Equipo>> buscarEquipo(){
				List <Equipo> listaEquipo = service.getAll();
				if (listaEquipo.isEmpty()) {
					return ResponseEntity.noContent().build();
				}else {
					return ResponseEntity.ok(listaEquipo);
						
				}
		}
		
		// Recuperar un solo equipo
		@GetMapping("/equipos/{id}")
		public ResponseEntity<Equipo> buscarEquipoPorId(@PathVariable Long id) {
			Equipo equipo = service.getById(id);
			if (equipo== null) {
				return ResponseEntity.notFound().build();
			}else {
				return ResponseEntity.ok(equipo);
			}
		}
		
		// Crear nuevo equipo
		@PostMapping ("/equipos")
		public ResponseEntity<Equipo> crearNuevoEquipo(@RequestBody Equipo equipo ) {
			try {
				Equipo equipoCreado = service.create(equipo);
				return ResponseEntity.ok(equipoCreado);
			}catch (Exception e) {
			return ResponseEntity.badRequest().build();
			}
		}
		// Actualizar equipo
		@PutMapping("/equipos/{id}")
		public ResponseEntity<Equipo> actualizarEquipo(@PathVariable Long id, @RequestBody Equipo equipo ) {
			Equipo equipoDesdeServicio = service.getById(id);
			if (equipoDesdeServicio == null) {
				return ResponseEntity.notFound().build();
			}else {
				try {
					Equipo equipoActualizado = service.update(equipo, id);
					return ResponseEntity.ok(equipoActualizado);
				}catch(Exception e) {
					return ResponseEntity.badRequest().build();
				}
			}
		
		}	
		
		// Eliminar equipo
		@DeleteMapping("/equipos/{id}")
		public ResponseEntity<?> borrarEquipoPorId(@PathVariable Long id) {
			
			Equipo equipo = service.getById(id);
			if (equipo==null) {
				return ResponseEntity.notFound().build();
			}else {
				service.delete(id);
				return ResponseEntity.ok().build();
			}
		}
}
