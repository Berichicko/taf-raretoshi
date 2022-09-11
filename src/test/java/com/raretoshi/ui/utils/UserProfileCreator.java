package com.raretoshi.ui.utils;

import com.raretoshi.ui.entity.UserProfile;

public class UserProfileCreator {

    public static UserProfile createUserProfileWithCorrectCredentials() {
        return new UserProfile(
                Random.NAME,
                Random.USER_NAME,
                Random.USER_INSTAGRAM,
                Random.USER_TWITTER,
                Random.USER_EMAIL,
                Random.USER_WEBSITE,
                Random.USER_LOCATION,
                Random.USER_BIO);
    }

    public static UserProfile createUserProfileWithInCorrectEmail() {
        return new UserProfile(
                Random.NAME,
                Random.USER_NAME,
                Random.USER_INSTAGRAM,
                Random.USER_TWITTER,
                Random.USER_INCORRECT_EMAIL,
                Random.USER_WEBSITE,
                Random.USER_LOCATION,
                Random.USER_BIO);
    }
}
