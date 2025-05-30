package com.quantumgear.Notificaciones.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name= "notificaciones")

public class NotificacionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String correoDestino;

    @Column(nullable = false)
    private String asunto;

    @Column(nullable = false, length = 500)
    private String mensaje;

    @Column(nullable = false)
    private String fechaEnvio;

}
