package com.raretoshi.api.utils;

import com.raretoshi.api.model.User;
import org.apache.commons.lang3.RandomStringUtils;

public class CreateUser {

    public static String setUserName() {
        return RandomStringUtils.randomAlphabetic(10);
    }

    public static String setUserPassword() {
        return RandomStringUtils.randomAlphanumeric(10);
    }

    public static String setNotValidEmptyUserName() {
        return "";
    }

    public static String setNotValidEmptyPassword() {
        return "";
    }

    public static String setUserEmail() {
        return RandomStringUtils.randomAlphabetic(10) + "@gmail.com";
    }

    public static User createNewUserCorrectEmailPassword() {
        return new User(UserData.USER_EMAIL,
                UserData.PASSWORD);
    }

    public User createNewUserNotValidNamePasswordRandomValues() {
        return new User(CreateUser.setUserName(),
                CreateUser.setUserPassword());
    }

    public User createNewUserNotValidEmptyNamePassword() {
        return new User(CreateUser.setNotValidEmptyUserName(),
                CreateUser.setNotValidEmptyPassword());
    }

    public User createNewUserNotValidEmailPasswordRandomValues() {
        return new User(CreateUser.setUserEmail(),
                CreateUser.setUserPassword());
    }
}
