package com.example.SistemaDeControl.Services;


import com.example.SistemaDeControl.Models.UserModel;
import com.example.SistemaDeControl.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService  {

    @Autowired
    UserRepository userRepository;

    public Optional<UserModel> login(UserModel userModel){
        List<UserModel> result = userRepository.findByUsername(userModel.getUsername());
        if (result.isEmpty()){
            return Optional.empty();
        } else {
            for (UserModel model : result) {
                if (model.getPassword().equals(userModel.getPassword())) {
                    return Optional.of(model);
                }
            }
        }
        return Optional.empty();
    }

}
