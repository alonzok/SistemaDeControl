package com.example.SistemaDeControl.Repositories;

import com.example.SistemaDeControl.Models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<UserModel, String> {
    List<UserModel> findByUsername(String username);

}
