package com.example.SistemaDeControl.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 * Modelo que representa un suscriptor en el sistema de control.
 * Contiene un ID, un código de evento y una URL para notificaciones.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriberModel {
    @Id
    private String id;
    private int codigoEvento;
    private String url;
}
