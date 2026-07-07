package com.gimnasio.gestion_gimnasio.instructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {
	
	@Autowired
	private InstructorRepository repo;
	
	public List<Instructor> getAll(){
		return repo.findAll();
	}
	public Instructor getById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public Instructor create(Instructor instructor) {
		return repo.save(instructor);
	}
	public Instructor update(Instructor instructor, Long id) {
		Instructor actualizarInstructor = this.getById(id);
		if (actualizarInstructor == null) {
			return null;
		}else {
			instructor.setId(id);
			return repo.save(instructor);
		}
	}
	public void delete(Long id) {
		repo.deleteById(id);
		
	}
}
