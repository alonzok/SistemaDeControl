package com.example.SistemaDeControl.Models.ChatGPT;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa un mensaje en la conversación con la API de ChatGPT.
 * Contiene el rol del emisor (usuario o sistema) y el contenido del mensaje.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String role;
    private String content;
}
