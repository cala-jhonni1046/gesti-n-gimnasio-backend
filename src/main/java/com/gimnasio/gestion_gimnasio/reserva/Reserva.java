package com.gimnasio.gestion_gimnasio.reserva;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Reserva {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private  String cliente_id;
	private String actividad_id;
	private LocalDate fechaHora;
	@Column(name = "estado", nullable = false)
	private String estado ;//(Confirmada, Asistió, Cancelada)
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(String cliente_id) {
		this.cliente_id = cliente_id;
	}
	public String getActividad_id() {
		return actividad_id;
	}
	public void setActividad_id(String actividad_id) {
		this.actividad_id = actividad_id;
	}
	public LocalDate getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(LocalDate fechaHora) {
		this.fechaHora = fechaHora;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
