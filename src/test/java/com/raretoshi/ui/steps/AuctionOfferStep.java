package com.raretoshi.ui.steps;

import com.raretoshi.ui.page.AuctionOfferPage;

public class AuctionOfferStep {

  public static AuctionOfferPage makeOfferAuction(String amountPrice) {
    return new AuctionOfferPage()
        .clickButtonMakeOffer()
        .enterPrice(amountPrice)
        .enterButtonSubmit()
        .enterButtonContinue();
  }
}
