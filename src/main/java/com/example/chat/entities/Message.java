package com.example.chat.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Message {
    private String message;
    private String fromLogin;
}
