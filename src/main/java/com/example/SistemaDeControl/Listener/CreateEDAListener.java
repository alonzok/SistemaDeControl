package com.example.SistemaDeControl.Listener;

import org.springframework.web.client.RestTemplate;

public class CreateEDAListener implements EventListener{

    private final String url;

    public CreateEDAListener(String url){
        this.url = url;
    }

    @Override
    public void update(int codigoEvento) {
        RestTemplate restTemplate = new RestTemplate();

        String uri = "http://192.168.100.117:8080"; // or any other uri

        String result = restTemplate.getForObject(url, String.class);
    }
}
