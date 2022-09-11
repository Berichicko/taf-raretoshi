package com.raretoshi.ui.steps;

import com.raretoshi.ui.entity.UserProfile;
import com.raretoshi.ui.page.EditProfilePage;

public class EditProfileStep {

    public static EditProfilePage editProfile(UserProfile user) {
        return new EditProfilePage()
                .clearInputFieldUserProfile()
                .editUserProfile(user)
                .clickButtonSaveDetails();
    }

    public static EditProfilePage getEditProfileEmptyCredentials() {
        return new EditProfilePage()
                .clearInputFieldUserProfile()
                .clickButtonSaveDetails();
    }
}
