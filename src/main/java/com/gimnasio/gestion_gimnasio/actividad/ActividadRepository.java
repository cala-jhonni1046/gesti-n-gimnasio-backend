package com.gimnasio.gestion_gimnasio.actividad;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ActividadRepository extends JpaRepository<Actividad,Long>{
	// JpaRepository ya tiene programados todos los métodos CRUD básicos
}
