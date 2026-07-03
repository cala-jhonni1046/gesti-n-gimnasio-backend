package com.gimnasio.gestion_gimnasio.membresia;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Membresia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombrePlan;
	private String descripcion;
	private double precio;
	private int duracionDias;
	private int limiteAsistencias;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombrePlan() {
		return nombrePlan;
	}
	
	public void setNombrePlan(String nombrePlan) {
		this.nombrePlan = nombrePlan;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public int getDuracionDias() {
		return duracionDias;
	}
	
	public void setDuracionDias(int duracionDias) {
		this.duracionDias = duracionDias;
	}
	
	public int getLimiteAsistencias() {
		return limiteAsistencias;
	}
	
	public void setLimiteAsistencias(int limiteAsistencias) {
		this.limiteAsistencias = limiteAsistencias;
	}
	
}
