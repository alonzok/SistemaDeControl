package com.example.SistemaDeControl.Listener;

import org.springframework.web.client.RestTemplate;

/**
 * Implementación de un listener que realiza una llamada HTTP a una URL específica cuando se actualiza un evento.
 */
public class CreateEDAListener implements EventListener{

    private final String url;

    public CreateEDAListener(String url){
        this.url = url;
    }

    /**
     * Método que se llama cuando ocurre un evento. Realiza una llamada HTTP GET a la URL especificada.
     * TODO: Implementar el la funcionalidad de update.
     * @param codigoEvento El código del evento que ha ocurrido.
     */
    @Override
    public void update(int codigoEvento) {
        RestTemplate restTemplate = new RestTemplate();

        String uri = "http://192.168.100.117:8080"; // or any other uri

        String result = restTemplate.getForObject(url, String.class);
    }
}
