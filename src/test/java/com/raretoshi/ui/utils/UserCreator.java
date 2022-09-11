package com.raretoshi.ui.utils;

import com.raretoshi.ui.entity.User;

public class UserCreator {

    public static final String USER_NAME_EMAIL =  DataProperties.getDataProperties("db.login");
    public static final String PASSWORD = DataProperties.getDataProperties("db.password");

    public static User createDefaultUser() {
        return new User(USER_NAME_EMAIL, PASSWORD);
    }

    public static User createIncorrectCredentialsUser() {
        return new User(Random.generateRandomAsciiString(), Random.generateRandomAsciiString());
    }
}
