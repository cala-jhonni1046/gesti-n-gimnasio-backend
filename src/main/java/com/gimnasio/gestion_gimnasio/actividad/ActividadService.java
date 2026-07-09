package com.gimnasio.gestion_gimnasio.actividad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActividadService {
	@Autowired
	private ActividadRepository repo;
	public List<Actividad> getAll(){
		return repo.findAll();
	}
	
	public Actividad getById(Long id) {
		return repo.findById(id).orElse(null);
	}
	public Actividad create(Actividad actividad) {
		return repo.save(actividad);
	}
	public Actividad update(Actividad actividad, Long id) {
		Actividad actualizarActividad=this.getById(id);
		if(actualizarActividad==null) {
			return null;
		}else {
			actividad.setId(id);
			return repo.save(actividad);
		}
	}
	public void delete (Long id) {
		repo.deleteById(id);
	}

}
