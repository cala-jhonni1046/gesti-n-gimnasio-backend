package com.gimnasio.gestion_gimnasio.notificacion;

import java.time.LocalDateTime;

import com.gimnasio.gestion_gimnasio.cliente.Cliente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Notificacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	 @ManyToOne
	  @JoinColumn(name = "cliente_id")
	  private Cliente cliente;
	
	private String mensaje;
	private LocalDateTime fechaEnvio;
	private Boolean leido;
	
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
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public LocalDateTime getFechaEnvio() {
		return fechaEnvio;
	}
	public void setFechaEnvio(LocalDateTime fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}
	public Boolean getLeido() {
		return leido;
	}
	public void setLeido(Boolean leido) {
		this.leido = leido;
	}
	
}
