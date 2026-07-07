package com.gimnasio.gestion_gimnasio.pago;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pago {
	
	

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id; // Siempre con "Long" mayúscula

	    private String suscripcion_id; // ID temporal en texto plano para ir paso a paso
	    private Double monto;          // Para números con decimales (precios)
	    private LocalDate fechaPago;
	    private String metodoPago;     // Ej: "Efectivo", "Tarjeta", "Transferencia"
	    
	    @Column(name = "comprobante")
	    private String comprobante; // Número de recibo o factura
	    
	    
	    

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getSuscripcion_id() {
			return suscripcion_id;
		}

		public void setSuscripcion_id(String suscripcion_id) {
			this.suscripcion_id = suscripcion_id;
		}

		public Double getMonto() {
			return monto;
		}

		public void setMonto(Double monto) {
			this.monto = monto;
		}

		public LocalDate getFechaPago() {
			return fechaPago;
		}

		public void setFechaPago(LocalDate fechaPago) {
			this.fechaPago = fechaPago;
		}

		public String getMetodoPago() {
			return metodoPago;
		}

		public void setMetodoPago(String metodoPago) {
			this.metodoPago = metodoPago;
		}

		public String getComprobante() {
			return comprobante;
		}

		public void setComprobante(String comprobante) {
			this.comprobante = comprobante;
		}

}
