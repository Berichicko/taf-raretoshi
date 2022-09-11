package com.raretoshi.ui.steps;

import com.raretoshi.ui.page.AuthorizedPage;
import com.raretoshi.ui.page.HomePage;
import com.raretoshi.ui.utils.UserCreator;

public class AuthorizeUserProfileStep {

    public static AuthorizedPage authorizedUserProfile() {
        return new HomePage()
                .clickSignIn()
                .authorize(UserCreator.createDefaultUser())
                .clickButtonAuthorizedUser();
    }
}
