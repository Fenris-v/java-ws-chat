package com.example.chat.controllers;

import com.example.chat.storage.UserStorage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@CrossOrigin
public class UserController {
    @GetMapping("/registration/{userName}")
    public ResponseEntity<Void> register(@PathVariable("userName") String login) {
        System.out.println("handling register user request: " + login);

        try {
            UserStorage.getInstance().setUser(login);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping("/fetchAllUsers")
    public Set<String> fetchAll() {
        return UserStorage.getInstance().getUsers();
    }
}
