package com.gimnasio.gestion_gimnasio.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ClienteService {
	@Autowired
	private ClienteRepositori repo;
	
	public List<Cliente> getAll(){
		return repo.findAll();
	}
	
	public Cliente  getById(Long id) {	
		return repo.findById(id).orElse(null);
	}
	
	public Cliente create(Cliente cliente){
		return repo.save(cliente);
		
	}
	
	public Cliente update(Cliente cliente, Long id) {
		Cliente actualizarCliente = this.getById(id);
		if(actualizarCliente == null) {
			return null;
		}else {
			cliente.setId(id);
			return repo.save(cliente);
		}	
		
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

}
