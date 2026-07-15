package com.gimnasio.gestion_gimnasio.notificacion;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NotificacionService {

	@Autowired
	private NotificacionRepository repo;
	
	public List<Notificacion> getAll() {
		return repo.findAll();
	}
	
	public Notificacion getById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public Notificacion create(Notificacion notificacion) {
		return repo.save(notificacion);
	}
	
	public Notificacion update(Notificacion notificacion, Long id) {
		Notificacion actualizarNotificacion = this.getById(id);
		if(actualizarNotificacion == null) {
			return null;
		} else {
			notificacion.setId(id);
			return repo.save(notificacion);
		}
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

	

}
