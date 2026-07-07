package com.gimnasio.gestion_gimnasio.reserva;

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
public class ReservaController {
	@Autowired
    private ReservaService service; // Nos comunicamos directamente con el servicio
    
    // GET: Recuperar todas las reservas existentes
    @GetMapping("/reservas")
    public ResponseEntity<List<Reserva>> buscarReservas() {
        List<Reserva> listaReservas = service.getAll();
        if (listaReservas.isEmpty()) {
            return ResponseEntity.noContent().build(); // Retorna 244 No Content si está vacía
        } else {
            return ResponseEntity.ok(listaReservas); // Retorna 200 OK con los datos
        }
    }
    
    // GET: Buscar una sola reserva por su ID en la URL
    @GetMapping("/reservas/{id}")
    public ResponseEntity<Reserva> buscarReservaPorId(@PathVariable Long id) {
        Reserva reserva = service.getById(id);
        if (reserva == null) {
            return ResponseEntity.notFound().build(); // Retorna 404 Not Found si no existe el ID
        } else {
            return ResponseEntity.ok(reserva); // Retorna 200 OK con la reserva encontrada
        }
    }
    
    // POST: Crear una nueva reserva ingresando un JSON en el cuerpo (RequestBody)
    @PostMapping("/reservas")
    public ResponseEntity<Reserva> crearNuevaReserva(@RequestBody Reserva reserva) {
        try {
            Reserva reservaCreada = service.create(reserva);
            return ResponseEntity.ok(reservaCreada); // Retorna 200 OK con el objeto guardado e ID autoincrementado
        } catch (Exception e) {
            return ResponseEntity.badRequest().build(); // Retorna 400 Bad Request si los tipos de datos fallan
        }
    }
    
    // PUT: Modificar una reserva existente enviando el ID en la URL y los datos en el cuerpo
    @PutMapping("/reservas/{id}")
    public ResponseEntity<Reserva> actualizarReserva(@PathVariable Long id, @RequestBody Reserva reserva) {
        Reserva reservaDesdeServicio = service.getById(id);
        if (reservaDesdeServicio == null) {
            return ResponseEntity.notFound().build(); // 404 si intentás modificar algo que no existe
        } else {
            try {
                Reserva reservaActualizada = service.update(reserva, id);
                return ResponseEntity.ok(reservaActualizada);
            } catch (Exception e) {
                return ResponseEntity.badRequest().build();
            }
        }
    }
    
    // DELETE: Eliminar una reserva físicamente de MySQL usando el ID de la URL
    @DeleteMapping("/reservas/{id}")
    public ResponseEntity<?> eliminarReserva(@PathVariable Long id) {
        Reserva reservaDesdeServicio = service.getById(id);
        if (reservaDesdeServicio == null) {
            return ResponseEntity.notFound().build(); // 404 si el ID no existe en la base de datos
        } else {
            service.delete(id);
            return ResponseEntity.ok().build(); // 200 OK plano indicando que se borró con éxito
        }
    }

}
