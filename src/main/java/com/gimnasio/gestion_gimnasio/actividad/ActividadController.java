package com.gimnasio.gestion_gimnasio.actividad;

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
public class ActividadController {
		@Autowired
		private ActividadService service;
		
		//Recuperar todas las actividades
		@GetMapping("/actividades")
		public ResponseEntity <List<Actividad>> buscarActividades(){
			List<Actividad> listaActividad = service.getAll();
			if (listaActividad.isEmpty()) {
				return ResponseEntity.noContent().build();
			}else {
				return ResponseEntity.ok(listaActividad);
			}
		}
		
		//Recuperar una sola actividad
		@GetMapping("/actividades/{id}")
		public ResponseEntity<Actividad> buscarActividadPorId(@PathVariable Long id){
			Actividad actividad = service.getById(id);
			if (actividad==null) {
				return ResponseEntity.notFound().build();
			}else {
				return ResponseEntity.ok(actividad);
			}
		}
		//Crear nueva actividad
		@PostMapping("/actividades")
		public ResponseEntity<Actividad> crearNuevaActividad(@RequestBody Actividad actividad){
			try {
				Actividad actividadCreada = service.create(actividad);
				return ResponseEntity.ok(actividadCreada);
			}catch (Exception e) {
				return ResponseEntity.badRequest().build();
			}
		}
		//Actualizar actividad
		@PutMapping("/actividades/{id}")
		public ResponseEntity<Actividad> actualizarActividad(@PathVariable Long id, @RequestBody Actividad actividad) {
			Actividad actividadDesdeServicio = service.getById(id);
			if (actividadDesdeServicio==null) {
				return ResponseEntity.notFound().build();
			}else {
				try {
					Actividad actividadActualizada= service.update(actividad,  id);
					return ResponseEntity.ok(actividadActualizada);
				}catch (Exception e) {
					return ResponseEntity.badRequest().build();
				}
			}
		}
		//Eliminar actividad
		@DeleteMapping("/actividades/{id}")
		public ResponseEntity<?> borrarActividadPorId(@PathVariable Long id){
			Actividad actividad = service.getById(id);
			if (actividad == null) {
				return ResponseEntity.notFound().build();
			}else {
				service.delete(id);
				return ResponseEntity.ok().build();
			}
		}
		
	
	

}
