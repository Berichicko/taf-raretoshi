package api.utils;

import api.model.ProfileUser;
import ui.utils.RandomApi;

public class CreateUserProfile {

    public ProfileUser createUserProfileWithCorrectCredentials() {
        return new ProfileUser(
                RandomApi.USER_BIO,
                RandomApi.USER_EMAIL,
                RandomApi.NAME,
                RandomApi.USER_INSTAGRAM,
                RandomApi.USER_LOCATION,
                RandomApi.USER_TWITTER,
                RandomApi.USER_NAME,
                RandomApi.USER_WEBSITE);
    }
}

