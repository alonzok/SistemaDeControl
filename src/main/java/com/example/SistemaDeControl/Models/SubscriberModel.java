package com.example.SistemaDeControl.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriberModel {
    @Id
    private String id;
    private int codigoEvento;
    private String url;
}
