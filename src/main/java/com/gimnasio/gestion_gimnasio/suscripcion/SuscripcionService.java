package com.gimnasio.gestion_gimnasio.suscripcion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuscripcionService {
	
	@Autowired
	private SuscripcionRepository repo;
	
	public List<Suscripcion> getAll(){
		return repo.findAll();
	}
	
	public Suscripcion getById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public Suscripcion create(Suscripcion suscripcion) {
		return repo.save(suscripcion);
	}
	
	public Suscripcion update(Suscripcion suscripcion, Long id) {
		Suscripcion actualizarSuscripcion = this.getById(id);
		if(actualizarSuscripcion == null) {
			return null;
		}else {
			suscripcion.setId(id);
			return repo.save(suscripcion);
		}
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

}
