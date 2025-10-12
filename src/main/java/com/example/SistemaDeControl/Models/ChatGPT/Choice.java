package com.example.SistemaDeControl.Models.ChatGPT;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa una opción de respuesta generada por la API de ChatGPT.
 * Contiene el índice de la opción y el mensaje asociado.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Choice {
    private int index;
    private Message message;
}