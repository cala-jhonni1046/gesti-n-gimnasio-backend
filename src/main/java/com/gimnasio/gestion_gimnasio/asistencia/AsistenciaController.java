package com.gimnasio.gestion_gimnasio.asistencia;

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
public class AsistenciaController {
		@Autowired
		private AsistenciaService service;
		
		//Recuperar todas las asistencias
		@GetMapping("/asistencias")
		public ResponseEntity <List<Asistencia>> buscarasistencias(){
			List<Asistencia> listaasistencia = service.getAll();
			if (listaasistencia.isEmpty()) {
				return ResponseEntity.noContent().build();
			}else {
				return ResponseEntity.ok(listaasistencia);
			}
		}
		
		//Recuperar una sola asistencia
		@GetMapping("/asistencias/{id}")
		public ResponseEntity<Asistencia> buscarasistenciaPorId(@PathVariable Long id){
			Asistencia asistencia = service.getById(id);
			if (asistencia==null) {
				return ResponseEntity.notFound().build();
			}else {
				return ResponseEntity.ok(asistencia);
			}
		}
		//Crear nueva asistencia
		@PostMapping("/asistencias")
		public ResponseEntity<Asistencia> crearNuevaasistencia(@RequestBody Asistencia asistencia){
			try {
				Asistencia asistenciaCreada = service.create(asistencia);
				return ResponseEntity.ok(asistenciaCreada);
			}catch (Exception e) {
				return ResponseEntity.badRequest().build();
			}
		}
		//Actualizar asistencia
		@PutMapping("/asistencias/{id}")
		public ResponseEntity<Asistencia> actualizarasistencia(@PathVariable Long id, @RequestBody Asistencia asistencia) {
			Asistencia asistenciaDesdeServicio = service.getById(id);
			if (asistenciaDesdeServicio==null) {
				return ResponseEntity.notFound().build();
			}else {
				try {
					Asistencia asistenciaActualizada= service.update(asistencia,  id);
					return ResponseEntity.ok(asistenciaActualizada);
				}catch (Exception e) {
					return ResponseEntity.badRequest().build();
				}
			}
		}
		//Eliminar asistencia
		@DeleteMapping("/asistencias/{id}")
		public ResponseEntity<?> borrarasistenciaPorId(@PathVariable Long id){
			Asistencia asistencia = service.getById(id);
			if (asistencia == null) {
				return ResponseEntity.notFound().build();
			}else {
				service.delete(id);
				return ResponseEntity.ok().build();
			}
		}
		
	
	

}
