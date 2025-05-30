package com.quantumgear.Notificaciones.controller;

import com.quantumgear.Notificaciones.model.NotificacionModel;
import com.quantumgear.Notificaciones.service.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping()

public class NotificacionController {
    @Autowired
    private NotificacionService notificacionService;

    @GetMapping
    public List<NotificacionModel> getAll() {
        return notificacionService.obtenerTodas();
    }

    @PostMapping
    public NotificacionModel create(@RequestBody NotificacionModel notificacion) {
        return notificacionService.guardar(notificacion);
    }

    @GetMapping("/correo/{correo}")
    public List<NotificacionModel> getByCorreo(@PathVariable String correo) {
        return notificacionService.buscarPorCorreo(correo);
    }

    @GetMapping("/asunto/{asunto}")
    public List<NotificacionModel> getByAsunto(@PathVariable String asunto) {
        return notificacionService.buscarPorAsunto(asunto);
    }

    @GetMapping("/buscar")
    public List<NotificacionModel> getByCorreoAndAsunto(
            @RequestParam String correo,
            @RequestParam String asunto) {
        return notificacionService.buscarPorCorreoYAsunto(correo, asunto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        notificacionService.eliminarPorId(id);
    }


}
