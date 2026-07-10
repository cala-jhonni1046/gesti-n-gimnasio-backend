package com.gimnasio.gestion_gimnasio.equipo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EquipoService {

	@Autowired
	private EquipoRepository repo;
	
	public List<Equipo> getAll() {
		return repo.findAll();
	}
	
	public Equipo getById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public Equipo create(Equipo equipo) {
		return repo.save(equipo);
	}
	
	public Equipo update(Equipo equipo, Long id) {
		Equipo actualizarEquipo = this.getById(id);
		if(actualizarEquipo == null) {
			return null;
		} else {
			equipo.setId(id);
			return repo.save(equipo);
		}
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

	

}