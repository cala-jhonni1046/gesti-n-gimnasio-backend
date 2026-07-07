package com.gimnasio.gestion_gimnasio.reserva;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ReservaService {
	
	@Autowired
    private ReservaRepository repo; // Inyectamos el repositorio para comunicarnos con la BD
    
    // 1. Obtener todas las reservas de la base de datos
    public List<Reserva> getAll() {
        return repo.findAll();
    }
    
    // 2. Obtener una reserva específica buscando por su ID único
    public Reserva getById(Long id) {
        return repo.findById(id).orElse(null); // Si no la encuentra, devuelve null
    }
    
    // 3. Crear una nueva reserva plana
    public Reserva create(Reserva reserva) {
        return repo.save(reserva);
    }
    
    // 4. Actualizar una reserva existente buscando primero si existe
    public Reserva update(Reserva reserva, Long id) {
        Reserva actualizarReserva = this.getById(id);
        if (actualizarReserva == null) {
            return null; // Si el ID no existe en XAMPP, no actualiza nada
        } else {
            reserva.setId(id); // Le aseguramos el ID que viene por la URL
            return repo.save(reserva); // Guarda los nuevos datos encima del registro viejo
        }
    }
    
    // 5. Eliminar un registro de la base de datos por su ID
    public void delete(Long id) {
        repo.deleteById(id);
    }
}

