package com.quantumgear.Notificaciones.service;

import com.quantumgear.Notificaciones.model.NotificacionModel;
import com.quantumgear.Notificaciones.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;
@Service
@Transactional
public class NotificacionService {

    @Autowired
    private NotificacionRepository notificacionRepository;

    public List<NotificacionModel> obtenerTodas() {
        return notificacionRepository.findAll();
    }

    public NotificacionModel guardar(NotificacionModel notificacion) {
        return notificacionRepository.save(notificacion);
    }

    public List<NotificacionModel> buscarPorCorreo(String correo) {
        return notificacionRepository.findByCorreo(correo);
    }

    public List<NotificacionModel> buscarPorAsunto(String asunto) {
        return notificacionRepository.findByAsunto(asunto);
    }

    public List<NotificacionModel> buscarPorCorreoYAsunto(String correo, String asunto) {
        return notificacionRepository.findByCorreoAndAsunto(correo, asunto);
    }

    public void eliminarPorId(Long id) {
        notificacionRepository.deleteById(id);
    }
}
