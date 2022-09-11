package com.raretoshi.ui.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private final String usernameEmail;
    private final String password;
}
