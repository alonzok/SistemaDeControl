package com.example.SistemaDeControl.Controllers;

import com.example.SistemaDeControl.Models.ChatGPT.ChatGPTRequest;
import com.example.SistemaDeControl.Models.ChatGPT.OpenAIResponse;
import com.example.SistemaDeControl.Models.SubscriberModel;
import com.example.SistemaDeControl.Repositories.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@RestController
public class ChatGPTController {
//    @Value("")
//    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private SubscriberRepository subscriberRepository;

    @PostMapping("/chat")
    public String chat(@RequestBody String prompt) {

        String url = "https://api.openai.com/v1/chat/completions";
        String model = "gpt-3.5-turbo";
        String apiKey = "";

        //            URL obj = new URL(url);
//            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
//            connection.setRequestMethod("POST");
//            connection.setRequestProperty("Authorization", "Bearer " + apiKey);
//            connection.setRequestProperty("Content-Type", "application/json");
//
//            // The request body
//            String body = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + prompt + "\"}]}";
//            connection.setDoOutput(true);
//            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
//            writer.write(body);
//            writer.flush();
//            writer.close();
//
//            // Response from ChatGPT
//            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            String line;
//
//            StringBuffer response = new StringBuffer();
//
//            while ((line = br.readLine()) != null) {
//                response.append(line);
//            }
//            br.close();
//
//            // calls the method to extract the message.
//            return extractMessageFromJSONResponse(response.toString());

//        ChatGPTRequest request = new ChatGPTRequest(model, prompt);
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Authorization", "Bearer " + apiKey);
//        OpenAIResponse chatResponse = restTemplate.postForObject(url, new HttpEntity<>(request, headers), OpenAIResponse.class);

//        notify(2, chatResponse.getChoices().get(0).getMessage().getContent());

//        return chatResponse.getChoices().get(0).getMessage().getContent();

        notify(2, "¿En qué le puedo ayudar hoy?");
        return "¿En qué le puedo ayudar hoy?";

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

        private String extractGeneratedResponse (String fullResponse){
            // Implement logic to extract the generated response without usage examples
            // This can include parsing JSON or using regular expressions
            // Modify this method based on the actual response structure

            // For illustration purposes, let's assume a simple scenario:
            // Remove everything after the first period (.)
            int index = fullResponse.indexOf(".");
            if (index != -1) {
                return fullResponse.substring(0, index + 1);
            } else {
                return fullResponse;
            }
        }

        private String extractMessageFromJSONResponse (String response){
            int start = response.indexOf("content")+ 11;

            int end = response.indexOf("\"", start);

            return response.substring(start, end);
        }
}
