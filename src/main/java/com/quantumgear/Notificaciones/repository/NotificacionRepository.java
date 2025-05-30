package com.quantumgear.Notificaciones.repository;

import com.quantumgear.Notificaciones.model.NotificacionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NotificacionRepository extends JpaRepository<NotificacionModel, Long> {

    @Query(value = "SELECT * FROM notificaciones", nativeQuery = true)
    List<NotificacionModel> findAll();

    @Query(value = "SELECT * FROM notificaciones WHERE correo_destino = :correo", nativeQuery = true)
    List<NotificacionModel> findByCorreo(@Param("correo") String correo);

    @Query(value = "SELECT * FROM notificaciones WHERE asunto = :asunto", nativeQuery = true)
    List<NotificacionModel> findByAsunto(@Param("asunto") String asunto);

    @Query(value = "SELECT * FROM notificaciones WHERE correo_destino = :correo AND asunto = :asunto", nativeQuery = true)
    List<NotificacionModel> findByCorreoAndAsunto(@Param("correo") String correo, @Param("asunto") String asunto);

    @Query(value = "DELETE FROM notificaciones WHERE id = :id", nativeQuery = true)
    void deleteById(@Param("id") Long id);
}
