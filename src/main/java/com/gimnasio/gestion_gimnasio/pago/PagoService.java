package com.gimnasio.gestion_gimnasio.pago;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagoService {
	@Autowired
    private PagoRepository repo;

    public List<Pago> getAll() {
        return repo.findAll();
    }

    public Pago getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Pago create(Pago pago) {
        return repo.save(pago);
    }

    public Pago update(Pago pago, Long id) {
        Pago actualizarPago = this.getById(id);
        if (actualizarPago == null) {
            return null;
        } else {
            pago.setId(id);
            return repo.save(pago);
        }
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}


