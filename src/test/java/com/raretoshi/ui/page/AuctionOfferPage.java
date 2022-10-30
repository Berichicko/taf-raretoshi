package com.raretoshi.ui.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuctionOfferPage extends BasePage {

  private final By INFO_CURRENT_BID_PRICE = By.xpath("//button[@class='text-lg svelte-1qkyhod']");
  private final By HISTORY_BID_PRICE = By.xpath("//div[@class='ml-3']//div");
  @FindBy(xpath = "//button[@class='secondary-btn svelte-1qkyhod']")
  private WebElement buttonMakeOffer;
  @FindBy(xpath = "//input[@id='price']")
  private WebElement inputPrice;
  @FindBy(xpath = "//button[@type='submit']")
  private WebElement buttonSubmit;
  @FindBy(xpath = "//button[@class='primary-btn mb-2 sm:mb-0 sm:ml-2']")
  private WebElement buttonContinue;
  @FindBy(xpath = "//div[@class='flex-grow mr-2']")
  private WebElement messageBidPlaced;

  @FindBy(xpath = "//div[@class='flex-grow mr-2']")
  private WebElement messageMinimumBid;

  @FindBy(xpath = "//div[@class='flex-grow mr-2']")
  private WebElement messageValueFractionalComponent;


  public AuctionOfferPage clickButtonMakeOffer() {
    fluentWaitForElementToBeClickable(buttonMakeOffer);
    buttonMakeOffer.click();
    return this;
  }

  public AuctionOfferPage enterPrice(String amountPrice) {
    fluentWaitForElementToBeClickable(inputPrice).sendKeys(amountPrice);
    return this;
  }

  public AuctionOfferPage enterButtonSubmit() {
    waitForElementToBeClickable(buttonSubmit).click();
    return this;
  }

  public AuctionOfferPage enterButtonContinue() {
    fluentWaitForElementToBeClickable(buttonContinue).click();
    return this;
  }

  public boolean isDisplayedMessageBidPlaced() {
    return messageBidPlaced.isDisplayed();
  }

  public boolean isDisplayedMessageMinimumBid() {
    waitForVisibilityOfElement(messageMinimumBid);
    return messageMinimumBid.isDisplayed();
  }

  public boolean isDisplayedValueFractionalComponent() {
    waitForVisibilityOfElement(messageValueFractionalComponent);
    return messageValueFractionalComponent.isDisplayed();
  }

  public String getCurrentBidPriceInfo() {
    fluentWaitForElementToBeNotVisible(messageBidPlaced);
    return driver.findElement(INFO_CURRENT_BID_PRICE).getAttribute("innerHTML");
  }

  public String getCurrentBidPriceHistory() {
    fluentWaitForElementToBeNotVisible(messageBidPlaced);
    return driver.findElement(HISTORY_BID_PRICE).getAttribute("innerText");
  }
}
