package com.example.SistemaDeControl.Controllers;

import com.example.SistemaDeControl.Services.ChatGPTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatGPTController {
    @Autowired
    private ChatGPTService chatGPTService;

    @PostMapping("/chat")
    public ResponseEntity<String> chat(@RequestBody String prompt) {

        return new ResponseEntity<String>(chatGPTService.chat(prompt), HttpStatus.ACCEPTED);

    }

}
