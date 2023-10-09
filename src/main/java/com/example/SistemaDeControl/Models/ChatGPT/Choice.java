package com.example.SistemaDeControl.Models.ChatGPT;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Choice {
    private int index;
    private Message message;
}