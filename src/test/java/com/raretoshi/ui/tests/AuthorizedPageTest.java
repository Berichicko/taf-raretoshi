package com.raretoshi.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.raretoshi.ui.page.AuthorizedPage;
import com.raretoshi.ui.steps.AuthorizeUserProfileStep;
import org.testng.asserts.SoftAssert;

public class AuthorizedPageTest extends BaseTest {

    @BeforeMethod
    public void openPageAuthorizeUserProfile() {
        AuthorizeUserProfileStep.authorizedUserProfile();

    }

    @Test
    public void testBitcoinQrAddressWallet() {
        AuthorizedPage authorizedPage = new AuthorizedPage();
        SoftAssert softAssert = new SoftAssert();
        authorizedPage.clickButtonBitcoinAddressWallet();
        softAssert.assertTrue(authorizedPage.isDisplayedButtonBitcoinAddressWallet());
        softAssert.assertEquals(authorizedPage.getButtonBitcoinAddressWalletText(), authorizedPage.getQrCodeBitcoinAddressWalletText());
    }

    @Test
    public void testIsDisplayedElementsAuthorizedPage() {
        AuthorizedPage authorizedPage = new AuthorizedPage();
        Assert.assertTrue(authorizedPage.isDisplayedElementsAuthorizedHomePage());

    }

    @Test
    public void testFollowersFollowingAmount() {
        SoftAssert softAssert = new SoftAssert();
        String expectedResultFollowersAmount = "Followers: 0";
        String expectedResultFollowingAmount = "Following: 0";
        AuthorizedPage authorizedPage = new AuthorizedPage();
        softAssert.assertEquals(expectedResultFollowersAmount, authorizedPage.getLabelFollowersAmountText());
        softAssert.assertEquals(expectedResultFollowingAmount, authorizedPage.getLabelFollowingAmountText());
    }
}
