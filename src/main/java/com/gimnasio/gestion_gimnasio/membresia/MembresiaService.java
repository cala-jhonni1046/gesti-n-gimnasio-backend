package com.gimnasio.gestion_gimnasio.membresia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembresiaService {
	
	@Autowired
	private MembresiaRepository repo;
	
	public List<Membresia> getAll(){
		return repo.findAll();
	}
	
	public Membresia getById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public Membresia create(Membresia membresia) {
		return repo.save(membresia);
	}
	
	public Membresia update(Membresia membresia, Long id) {
		Membresia actualizarMembresia = this.getById(id);
		if(actualizarMembresia == null) {
			return null;
		}else {
			membresia.setId(id);
			return repo.save(membresia);
		}
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

}
