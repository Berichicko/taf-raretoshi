package com.raretoshi.ui.tests;

import com.raretoshi.ui.page.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest extends BaseTest {

  @Test
  public void testIsDisplayedButtonHomePage() {
    HomePage homePage = new HomePage();
    SoftAssert softAssert = new SoftAssert();
    homePage.scrollPageDown();
    softAssert.assertTrue(homePage.isDisplayedImageLogo());
    softAssert.assertTrue(homePage.isDisplayedButtonStartExploring());
    softAssert.assertTrue(homePage.isDisplayedButtonSignIn());
    softAssert.assertTrue(homePage.isDisplayedButtonMarket());
    softAssert.assertTrue(homePage.isDisplayedButtonActivity());
    softAssert.assertTrue(homePage.isDisplayedButtonBlog());
    softAssert.assertTrue(homePage.isDisplayedButtonHelp());
    softAssert.assertTrue(homePage.isDisplayedButtonViewArtwork());
    softAssert.assertTrue(homePage.isDisplayedButtonViewGallery());
    softAssert.assertTrue(homePage.isDisplayedButtonViewMore());
    softAssert.assertAll();

  }

  @Test
  public void testIsDisplayedImageNameCardArtwork() {
    HomePage homePage = new HomePage();
    SoftAssert softAssert = new SoftAssert();
    softAssert.assertTrue(homePage.isDisplayedImageCardArtwork());
    softAssert.assertTrue(homePage.isDisplayedNameCardArtworkRecentActivity());
    softAssert.assertTrue(homePage.isDisplayedNameCardArtworkLatestPieces());

  }

  @Test
  public void testTextLabelHomePage() {
    String expectedResultNameLogo = "Raretoshi" + "\n" + "digital art";
    String expectedResultDescriptionLogo = "Upload, collect, and transact rare digital art on the Liquid Network";
    String expectedResultNameInputPlaceholder = "Search...";
    String expectedResultLabelRecentActivity = "Recent Activity";
    String expectedResultLabelLatestPieces = "Latest Pieces";
    SoftAssert softAssert = new SoftAssert();
    HomePage homePage = new HomePage();
    softAssert.assertEquals(expectedResultNameLogo, homePage.getNameLogo());
    softAssert.assertEquals(expectedResultDescriptionLogo, homePage.getDescriptionLogo());
    softAssert.assertEquals(expectedResultNameInputPlaceholder, homePage.getTextInputSearchPlaceholder());
    softAssert.assertEquals(expectedResultLabelRecentActivity, homePage.getTextLabelRecentActivity());
    softAssert.assertEquals(expectedResultLabelLatestPieces, homePage.getTexLabelLatestPieces());
    softAssert.assertAll();

  }
}
