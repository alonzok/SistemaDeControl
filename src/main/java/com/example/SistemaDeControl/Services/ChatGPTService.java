package com.example.SistemaDeControl.Services;

import com.example.SistemaDeControl.Models.ChatGPT.ChatGPTRequest;
import com.example.SistemaDeControl.Models.ChatGPT.OpenAIResponse;
import com.example.SistemaDeControl.Models.SubscriberModel;
import com.example.SistemaDeControl.Repositories.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ChatGPTService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private SubscriberRepository subscriberRepository;

    public String chat(String prompt){
        String url = "https://api.openai.com/v1/chat/completions";
        String model = "gpt-3.5-turbo";
        String apiKey = "";
        ChatGPTRequest request = new ChatGPTRequest(model, prompt);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + apiKey);
        OpenAIResponse chatResponse = restTemplate.postForObject(url, new HttpEntity<>(request, headers), OpenAIResponse.class);

        notify(2, chatResponse.getChoices().get(0).getMessage().getContent());
        return chatResponse.getChoices().get(0).getMessage().getContent();

//        notify(2, "¿En qué le puedo ayudar hoy?");
//        return "¿En qué le puedo ayudar hoy?";

    }

    private void notify ( int codigoEvento, String mensaje){
        try {
            List<SubscriberModel> subscriberModelList = subscriberRepository.findByCodigoEvento(codigoEvento);
            for (SubscriberModel subscriber : subscriberModelList) {
                RestTemplate restTemplate = new RestTemplate();
                String uri = subscriber.getUrl(); // or any other uri
                String result = restTemplate.postForObject(uri, mensaje, String.class);
                System.out.println(result);

            }
        } catch (Exception err) {
            System.out.println(err);
        }
    }


}
