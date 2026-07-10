package com.gimnasio.gestion_gimnasio.actividad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Actividad {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id; // Siempre Long con mayúscula como objeto

	    private String nombre;       // Ej: "Crossfit", "Spinning"
	    private String descripcion;  // Ej: "Entrenamiento de alta intensidad"
	    private Integer duracion;    // Duración en minutos (ej: 60)
	    private Integer capacidad;   // Cupo máximo de alumnos (ej: 20)
	    
	    // Guardamos el instructor como un String plano temporal para ir de a poco
	    private String instructor_id;
	    
	    
	    
	    
	 // --- GETTERS Y SETTERS ---
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public Integer getDuracion() {
			return duracion;
		}

		public void setDuracion(Integer duracion) {
			this.duracion = duracion;
		}

		public Integer getCapacidad() {
			return capacidad;
		}

		public void setCapacidad(Integer capacidad) {
			this.capacidad = capacidad;
		}

		public String getInstructor_id() {
			return instructor_id;
		}

		public void setInstructor_id(String instructor_id) {
			this.instructor_id = instructor_id;
		}

}
