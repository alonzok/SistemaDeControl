package com.example.SistemaDeControl.Repositories;

import com.example.SistemaDeControl.Models.SubscriberModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SubscriberRepository extends MongoRepository<SubscriberModel, Integer> {
    List<SubscriberModel> findByCodigoEvento(int codigoEvento);
}
