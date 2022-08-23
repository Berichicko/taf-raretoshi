package ui.utils;

import ui.entity.UserProfile;

public class UserProfileCreator {

    public static UserProfile createUserProfileWithCorrectCredentials() {
        return new UserProfile(
                RandomApi.NAME,
                RandomApi.USER_NAME,
                RandomApi.USER_INSTAGRAM,
                RandomApi.USER_TWITTER,
                RandomApi.USER_EMAIL,
                RandomApi.USER_WEBSITE,
                RandomApi.USER_LOCATION,
                RandomApi.USER_BIO);
    }

    public static UserProfile createUserProfileWithInCorrectEmail() {
        return new UserProfile(
                RandomApi.NAME,
                RandomApi.USER_NAME,
                RandomApi.USER_INSTAGRAM,
                RandomApi.USER_TWITTER,
                RandomApi.USER_INCORRECT_EMAIL,
                RandomApi.USER_WEBSITE,
                RandomApi.USER_LOCATION,
                RandomApi.USER_BIO);
    }
}
