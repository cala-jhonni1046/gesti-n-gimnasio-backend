package com.gimnasio.gestion_gimnasio.rutina;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RutinaService {
	
	@Autowired
	private RutinaRepository repo;
	
	public List<Rutina> getAll(){
		return repo.findAll();
	}
	
	public Rutina getById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public Rutina create(Rutina rutina) {
		return repo.save(rutina);
	}
	
	public Rutina update(Rutina rutina, Long id) {
		Rutina actualizarRutina = this.getById(id);
		if(actualizarRutina == null) {
			return null;
		}else {
			rutina.setId(id);
			return repo.save(rutina);
		}
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

}
