package com.gimnasio.gestion_gimnasio.actividad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActividadService {
	@Autowired // ➔ INYECCIÓN DE DEPENDENCIAS: Conecta automáticamente este servicio con el Repositorio.
    private ActividadRepository repo; // Crea una instancia 'repo' para poder usar los métodos de la base de datos.

    // 1. Método para obtener todas las actividades
    public List<Actividad> getAll() {
        return repo.findAll(); // Llama al repositorio y ejecuta un "SELECT * FROM" automático
    }

    // 2. Método para buscar una sola actividad por su número de ID
    public Actividad getById(Long id) {
        // Busca en la tabla por ID. Si lo encuentra lo devuelve, si no (.orElse), devuelve 'null' (nada)
        return repo.findById(id).orElse(null); 
    }

    // 3. Método para guardar una nueva actividad
    public Actividad create(Actividad actividad) {
        return repo.save(actividad); // Toma el objeto que le mandamos y ejecuta un "INSERT INTO" en MySQL
    }

    // 4. Método para modificar una actividad existente
    public Actividad update(Actividad actividad, Long id) {
        Actividad actualizarActividad = this.getById(id); // Primero busca si la actividad existe en XAMPP
        if (actualizarActividad == null) {
            return null; // Si no existe, frena acá y devuelve 'null' (no actualiza nada)
        } else {
            actividad.setId(id); // Si existe, le asegura el ID correcto que venía en la URL
            return repo.save(actividad); // El método '.save()' es inteligente: si el ID ya existe, hace un UPDATE en vez de un INSERT
        }
    }

    // 5. Método para borrar un registro
    public void delete(Long id) {
        repo.deleteById(id); // Ejecuta un "DELETE FROM actividad WHERE id = ..." en MySQL
    }
}


