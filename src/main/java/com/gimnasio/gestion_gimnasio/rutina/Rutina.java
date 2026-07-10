package com.gimnasio.gestion_gimnasio.rutina;

import com.gimnasio.gestion_gimnasio.cliente.Cliente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Rutina {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	private String nombreRutina;
	private String ejerciciosDetalle;
	private String nivelDificultad;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String getNombreRutina() {
		return nombreRutina;
	}
	
	public void setNombreRutina(String nombreRutina) {
		this.nombreRutina = nombreRutina;
	}
	
	public String getEjerciciosDetalle() {
		return ejerciciosDetalle;
	}
	
	public void setEjerciciosDetalle(String ejerciciosDetalle) {
		this.ejerciciosDetalle = ejerciciosDetalle;
	}
	
	public String getNivelDificultad() {
		return nivelDificultad;
	}
	
	public void setNivelDificultad(String nivelDificultad) {
		this.nivelDificultad = nivelDificultad;
	}
	
}
