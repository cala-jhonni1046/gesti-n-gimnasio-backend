package com.gimnasio.gestion_gimnasio.notificacion;

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
public class NotificacionController {
	
	@Autowired
	private NotificacionService service;
	
	// Recuperar todos las notificaciones
	@GetMapping ("/notificaciones")
	public ResponseEntity< List<Notificacion>> buscarNotificaciones(){
			List <Notificacion> listaNotificacion = service.getAll();
			if (listaNotificacion.isEmpty()) {
				return ResponseEntity.noContent().build();
			}else {
				return ResponseEntity.ok(listaNotificacion);
					
			}
	}
	
	// Recuperar una sola notificacion
	@GetMapping("/notificaciones/{id}")
	public ResponseEntity<Notificacion> buscarNotificacionPorId(@PathVariable Long id) {
		Notificacion notificacion = service.getById(id);
		if (notificacion== null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(notificacion);
		}
	}
	
	// Crear nueva notificacion
	@PostMapping ("/notificaciones")
	public ResponseEntity<Notificacion> crearNuevoNotificacion(@RequestBody Notificacion notificacion ) {
		try {
			Notificacion notificacionCreado = service.create(notificacion);
			return ResponseEntity.ok(notificacionCreado);
		}catch (Exception e) {
		return ResponseEntity.badRequest().build();
		}
	}
	// Actualizar notificacion
	@PutMapping("/notificaciones/{id}")
	public ResponseEntity<Notificacion> actualizarNotificacion(@PathVariable Long id, @RequestBody Notificacion notificacion ) {
		Notificacion notificacionDesdeServicio = service.getById(id);
		if (notificacionDesdeServicio == null) {
			return ResponseEntity.notFound().build();
		}else {
			try {
				Notificacion notificacionActualizado = service.update(notificacion, id);
				return ResponseEntity.ok(notificacionActualizado);
			}catch(Exception e) {
				return ResponseEntity.badRequest().build();
			}
		}
	
	}	
	
	// Eliminar notificacion
	@DeleteMapping("/notificaciones/{id}")
	public ResponseEntity<?> borrarNotificacionPorId(@PathVariable Long id) {
		
		Notificacion notificacion = service.getById(id);
		if (notificacion==null) {
			return ResponseEntity.notFound().build();
		}else {
			service.delete(id);
			return ResponseEntity.ok().build();
		}
	}
}
