package com.gimnasio.gestion_gimnasio.actividad;

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
public class ActividadController {
	@Autowired // ➔ Conecta automáticamente el Controlador con el Servicio (su cerebro)
    private ActividadService service;

    // --- PETICIÓN GET (LISTAR TODO) ---
    @GetMapping("/actividades") // Si alguien entra a 'GET http://localhost:8080/api/actividades' corre esto:
    public ResponseEntity<List<Actividad>> buscarActividades() {
        List<Actividad> listaActividades = service.getAll(); // Le pide la lista al servicio
        if (listaActividades.isEmpty()) {
            return ResponseEntity.noContent().build(); // Si la lista no tiene nada, devuelve código 204 (No Content)
        } else {
            return ResponseEntity.ok(listaActividades); // Si tiene datos, devuelve código 200 OK junto con la lista JSON
        }
    }

    // --- PETICIÓN GET POR ID (BUSCAR UNA SOLA) ---
    @GetMapping("/actividades/{id}") // El '{id}' significa que el número va a cambiar en la URL (ej: /actividades/3)
    // '@PathVariable Long id' atrapa el número que el usuario puso en la URL y se lo mete a la variable 'id'
    public ResponseEntity<Actividad> buscarActividadPorId(@PathVariable Long id) {
        Actividad actividad = service.getById(id); // Le pide al servicio que busque ese ID
        if (actividad == null) {
            return ResponseEntity.notFound().build(); // Si el servicio dio null, responde con un 404 Not Found
        } else {
            return ResponseEntity.ok(actividad); // Si la encontró, responde 200 OK con los datos de esa actividad
        }
    }

    // --- PETICIÓN POST (CREAR NUEVA) ---
    @PostMapping("/actividades") // Si mandan un POST a '/api/actividades' corre esto:
    // '@RequestBody Actividad actividad' agarra el JSON que escribiste en Postman y lo transforma en un objeto de Java
    public ResponseEntity<Actividad> crearNuevaActividad(@RequestBody Actividad actividad) {
        try {
            Actividad actividadCreada = service.create(actividad); // Llama al servicio para mandarlo a guardar
            return ResponseEntity.ok(actividadCreada); // Responde 200 OK con la actividad ya guardada y con su ID nuevo
        } catch (Exception e) {
            return ResponseEntity.badRequest().build(); // Si el JSON vino con errores de escritura, responde 400 Bad Request
        }
    }

    // --- PETICIÓN PUT (MODIFICAR) ---
    @PutMapping("/actividades/{id}") // Pide el ID en la URL y los datos nuevos en el Body
    public ResponseEntity<Actividad> actualizarActividad(@PathVariable Long id, @RequestBody Actividad actividad) {
        Actividad actividadDesdeServicio = service.getById(id); // Primero verifica si existe
        if (actividadDesdeServicio == null) {
            return ResponseEntity.notFound().build(); // Si no existe, devuelve 404 y no toca nada
        } else {
            try {
                Actividad actividadActualizada = service.update(actividad, id); // Manda a actualizar
                return ResponseEntity.ok(actividadActualizada); // Devuelve 200 OK con los cambios hechos
            } catch (Exception e) {
                return ResponseEntity.badRequest().build(); // 400 si fallaron los datos
            }
        }
    }

    // --- PETICIÓN DELETE (BORRAR) ---
    @DeleteMapping("/actividades/{id}") // Pide el ID que se va a eliminar en la URL
    public ResponseEntity<?> eliminarActividad(@PathVariable Long id) {
        Actividad actividadDesdeServicio = service.getById(id); // Verifica si existe antes de borrar
        if (actividadDesdeServicio == null) {
            return ResponseEntity.notFound().build(); // 404 si querés borrar algo que ya no existe
        } else {
            service.delete(id); // Llama al servicio para ejecutar el borrado físico en MySQL
            return ResponseEntity.ok().build(); // Responde un 200 OK plano confirmando que se borró con éxito
        }
    }
}
