package com.gimnasio.gestion_gimnasio.pago;

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
@RestController
public class PagoController {
	@Autowired
    private PagoService service;

    // Recuperar todos los pagos
    @GetMapping("/pagos")
    public ResponseEntity<List<Pago>> buscarPagos() {
        List<Pago> listaPagos = service.getAll();
        if (listaPagos.isEmpty()) {
            return ResponseEntity.noContent().build(); // Devuelve 204 si está vacío
        } else {
            return ResponseEntity.ok(listaPagos);      // Devuelve 200 OK con la lista
        }
    }


    // Recuperar un pago por ID
    @GetMapping("/pagos/{id}")
    public ResponseEntity<Pago> buscarPagoPorId(@PathVariable Long id) {
        Pago pago = service.getById(id);
        if (pago == null) {
            return ResponseEntity.notFound().build(); // Devuelve 404
        } else {
            return ResponseEntity.ok(pago);           // Devuelve 200 OK
        }
    }

    // Crear un nuevo pago
    @PostMapping("/pagos")
    public ResponseEntity<Pago> crearNuevoPago(@RequestBody Pago pago) {
        try {
            Pago pagoCreado = service.create(pago);
            return ResponseEntity.ok(pagoCreado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build(); // Devuelve 400 si falla algo
        }
    }

    // Actualizar un pago existente
    @PutMapping("/pagos/{id}")
    public ResponseEntity<Pago> actualizarPago(@PathVariable Long id, @RequestBody Pago pago) {
        Pago pagoDesdeServicio = service.getById(id);
        if (pagoDesdeServicio == null) {
            return ResponseEntity.notFound().build();
        } else {
            try {
                Pago pagoActualizado = service.update(pago, id);
                return ResponseEntity.ok(pagoActualizado);
            } catch (Exception e) {
                return ResponseEntity.badRequest().build();
            }
        }
    }

    // Eliminar un pago
    @DeleteMapping("/pagos/{id}")
    public ResponseEntity<?> eliminarPago(@PathVariable Long id) {
        Pago pagoDesdeServicio = service.getById(id);
        if (pagoDesdeServicio == null) {
            return ResponseEntity.notFound().build();
        } else {
            service.delete(id);
            return ResponseEntity.ok().build();
        }
    }

}

