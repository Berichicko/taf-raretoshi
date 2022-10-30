package com.raretoshi.ui.tests;

import com.raretoshi.ui.page.AuthorizedPage;
import com.raretoshi.ui.page.EditProfilePage;
import com.raretoshi.ui.steps.AuthorizeUserProfileStep;
import com.raretoshi.ui.steps.EditProfileStep;
import com.raretoshi.ui.utils.Random;
import com.raretoshi.ui.utils.UserProfileCreator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class EditProfilePageTest extends BaseTest {

    @BeforeMethod
    public void openPageEditProfile() {
        AuthorizeUserProfileStep.authorizedUserProfile();
        new AuthorizedPage()
                .clickButtonEditProfile();
    }

    @Test
    public void testEditProfileEmptyCredentials() {
        SoftAssert softAssert = new SoftAssert();
        String expectedMessageUsernameTaken = "Username taken";
        String expectLabelEditProfile = "Edit Profile";
        String expectedLabelName = "Name";
        String expectedLabelUsername = "Username";
        EditProfilePage editProfilePage = new EditProfilePage();
        EditProfileStep.getEditProfileEmptyCredentials();
        softAssert.assertEquals(expectLabelEditProfile, editProfilePage.getlabelEditProfileText());
        softAssert.assertEquals(expectedLabelName, editProfilePage.getlabelNameText());
        softAssert.assertEquals(expectedLabelUsername, editProfilePage.getlabelUserNameText());
        softAssert.assertEquals(expectedMessageUsernameTaken, editProfilePage.getMessageUsernameTaken());
        softAssert.assertAll();
    }

    @Test
    public void testEditProfileWithCorrectCredentials() {
        SoftAssert softAssert = new SoftAssert();
        String expectedResultMessageProfileUpdated = "Profile updated";
        EditProfileStep.editProfile(UserProfileCreator.createUserProfileWithCorrectCredentials());
        AuthorizedPage authorizedPage = new AuthorizedPage();
        softAssert.assertEquals(expectedResultMessageProfileUpdated, authorizedPage.getMessageProfileUpdatedText());
        softAssert.assertEquals(Random.NAME, authorizedPage.getUserNameText(), "User NAME");
        softAssert.assertEquals(Random.USER_EMAIL, authorizedPage.getUserEmailText(), "User EMAIL");
        softAssert.assertEquals(Random.USER_TWITTER, authorizedPage.getUserTwitterText(), "User TWITTER");
        softAssert.assertEquals(Random.USER_INSTAGRAM, authorizedPage.getUserInstagramText(), "User INSTAGRAM");
        softAssert.assertEquals(Random.USER_LOCATION, authorizedPage.getUserLocationText(), "User LOCATION");
        softAssert.assertEquals(Random.USER_WEBSITE, authorizedPage.getUserWebsiteText(), "User WEBSITE");
        softAssert.assertEquals(Random.USER_BIO, authorizedPage.getUserBioText(), "User BIO");
        softAssert.assertAll();

    }

    @Test
    public void testEditProfileWithInCorrectEmail() {
        String expectedResultMessageInvalidEmail = "Invalid email";
        EditProfilePage editProfilePage = new EditProfilePage();
        EditProfileStep.editProfile(UserProfileCreator.createUserProfileWithInCorrectEmail());
        Assert.assertEquals(expectedResultMessageInvalidEmail, editProfilePage.getMessageInvalidEmail(), "User EMAIL");

    }
}
