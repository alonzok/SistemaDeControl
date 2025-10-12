package com.example.SistemaDeControl.Controllers;

import com.example.SistemaDeControl.Models.UserModel;
import com.example.SistemaDeControl.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path = "/login")
    public ResponseEntity<Optional<UserModel>> login(@RequestBody UserModel userModel){

        Optional<UserModel> userModelOptional = userService.login(userModel);
        if(userModelOptional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);

        }
        return new ResponseEntity<>(userModelOptional, HttpStatus.ACCEPTED);
    }

}
