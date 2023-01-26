package com.example.chat.storage;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

public class UserStorage {
    private static UserStorage instance;

    @Getter
    private final Set<String> users;

    private UserStorage() {
        users = new HashSet<>();
    }

    public static synchronized UserStorage getInstance() {
        if (instance == null) {
            instance = new UserStorage();
        }

        return instance;
    }

    public void setUser(String login) throws Exception {
        if (users.contains(login)) {
            throw new Exception("User already exists");
        }

        users.add(login);
    }
}
