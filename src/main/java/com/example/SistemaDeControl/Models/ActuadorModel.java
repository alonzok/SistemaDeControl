package com.example.SistemaDeControl.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Modelo que representa un actuador en el sistema de control.
 * Contiene un ID, un nombre y un estado activo/inactivo.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActuadorModel {

    private int id;
    private String nombre;
    private boolean activo;

}
