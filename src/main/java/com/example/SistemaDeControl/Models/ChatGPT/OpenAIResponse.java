package com.example.SistemaDeControl.Models.ChatGPT;

import java.util.List;

/**
 * Clase que representa la respuesta de la API de OpenAI (ChatGPT).
 * Contiene una lista de opciones de respuesta generadas por el modelo.
 */
public class OpenAIResponse {
    private List<Choice> choices;

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }


}
