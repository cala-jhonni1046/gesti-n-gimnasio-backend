package com.gimnasio.gestion_gimnasio.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gimnasio.gestion_gimnasio.pago.Pago;



@RestController
public class ClienteController {
	@Autowired
	private ClienteService service;
	
	// Recuperar todas
	@GetMapping("/clientes")
	public ResponseEntity <List<Cliente>> buscarClientes(){
		List <Cliente>listaClientes = service.getAll();
		if (listaClientes.isEmpty()) {
			return ResponseEntity.noContent().build();
			
		}else {
			return ResponseEntity.ok(listaClientes);
		}
		
	}
	
	// Recuperar una sola
	@GetMapping("/cliente/{id}")
	public ResponseEntity <Cliente >buscarClientePorId(@PathVariable Long id) {
		Cliente cliente = service.getById(id);
		if (cliente == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(cliente);
			
		}	
			
		
		
	}
	
	// Crear nueva Cliente
	@PostMapping("/clientes")
	public ResponseEntity <Cliente> crearNuevoCliente(@RequestBody Cliente cliente ) {
		try {
			Cliente clienteCreda = service.create(cliente);
			 return ResponseEntity.ok(clienteCreda);
		}catch(Exception e ) {
			 return ResponseEntity.badRequest().build();
		}
		
	}
	
	// Actualizar Cliente
	@PutMapping("/cliente/{id}")
	public ResponseEntity < Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente ) {
		Cliente clienteDesdeServicio = service.getById(id);
		if (clienteDesdeServicio  == null) {
			return ResponseEntity.notFound().build();
		}else {
			try {
				Cliente ClienteActualisada = service.update(cliente, id);
				 return ResponseEntity.ok(ClienteActualisada);
			}catch(Exception e ) {
				 return ResponseEntity.badRequest().build();
			}
			
		}
	}
		// Eliminar un cliente
	    @DeleteMapping("/cliente/{id}")
	    public ResponseEntity<?> eliminarCliente(@PathVariable Long id) {
	        Cliente clienteDesdeServicio = service.getById(id);
	        if ( clienteDesdeServicio== null) {
	            return ResponseEntity.notFound().build();
	        } else {
	            service.delete(id);
	            return ResponseEntity.ok().build();
	        }
	    }


	}

