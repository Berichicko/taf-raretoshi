package com.raretoshi.ui.tests;

import com.raretoshi.ui.page.AuctionOfferPage;
import com.raretoshi.ui.page.HomePage;
import com.raretoshi.ui.steps.AuctionOfferStep;
import com.raretoshi.ui.steps.LoginStep;
import com.raretoshi.ui.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AuctionOfferTest extends BaseTest {

  @Test(priority = 1, description = "Check valid values when make an offer")
  public void testMakeOfferCorrectly() {
    SoftAssert softAssert = new SoftAssert();
    AuctionOfferPage auctionOfferPage = new AuctionOfferPage();
    LoginStep.logIn();
    new HomePage().enterArtworkForests();
    AuctionOfferStep.makeOfferAuction(Constants.MINIMUM_BID);
    String actualResultCurrentBidPriceInfo = auctionOfferPage.getCurrentBidPriceInfo()
        .replaceAll("[^0-9]\\.|\\.[^0-9]|[^0-9.\\s]|\\n|\\s", "");
    String actualResultCurrentBidPriceHistory = auctionOfferPage.getCurrentBidPriceHistory()
        .replaceAll("[^0-9]\\.|\\.[^0-9]|[^0-9.\\s]|\\n|\\s", "");
    softAssert.assertTrue(auctionOfferPage.isDisplayedMessageBidPlaced());
    softAssert.assertEquals(actualResultCurrentBidPriceHistory, Constants.MINIMUM_BID);
  }
}
