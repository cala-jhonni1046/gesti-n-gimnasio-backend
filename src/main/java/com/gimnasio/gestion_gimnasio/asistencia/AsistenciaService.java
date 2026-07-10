package com.gimnasio.gestion_gimnasio.asistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsistenciaService {
	@Autowired
	private AsistenciaRepository repo;
	public List<Asistencia> getAll(){
		return repo.findAll();
	}
	
	public Asistencia getById(Long id) {
		return repo.findById(id).orElse(null);
	}
	public Asistencia create(Asistencia asistencia) {
		return repo.save(asistencia);
	}
	public Asistencia update(Asistencia asistencia, Long id) {
		Asistencia actualizarasistencia=this.getById(id);
		if(actualizarasistencia==null) {
			return null;
		}else {
			asistencia.setId(id);
			return repo.save(asistencia);
		}
	}
	public void delete (Long id) {
		repo.deleteById(id);
	}

}
