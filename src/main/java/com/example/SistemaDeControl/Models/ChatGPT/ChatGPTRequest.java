package com.example.SistemaDeControl.Models.ChatGPT;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una solicitud a la API de ChatGPT.
 * Contiene el modelo a utilizar y una lista de mensajes.
 */
@Getter
@Setter
public class ChatGPTRequest {
    private String model;
    private List<Message> messages = new ArrayList<>();

    public ChatGPTRequest(String model, String prompt){
        this.model = model;
        this.messages.add(new Message("user", prompt));
    }

}
