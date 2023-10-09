package com.example.SistemaDeControl.Repositories;

import com.example.SistemaDeControl.Models.ActuadorModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActuadorRepository extends MongoRepository<ActuadorModel, Integer> {
}
