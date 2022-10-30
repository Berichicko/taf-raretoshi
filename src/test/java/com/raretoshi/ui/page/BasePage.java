package com.raretoshi.ui.page;

import static com.raretoshi.ui.driver.DriverSingleton.getDriver;

import com.raretoshi.ui.driver.DriverSingleton;
import com.raretoshi.ui.utils.Constants;
import java.time.Duration;
import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class BasePage {

  protected static final Logger LOGGER = LogManager.getLogger();
  protected WebDriver driver;

  protected BasePage() {
    driver = DriverSingleton.initializeDriver();
    PageFactory.initElements(driver, this);

  }

  protected boolean waitForElementToBeNotVisible(WebElement webElement) {
    boolean isWebElementNotVisible = false;
    try {
      isWebElementNotVisible = new WebDriverWait(getDriver(), 2).until(ExpectedConditions
          .invisibilityOf(webElement));
    } catch (TimeoutException e) {
      isWebElementNotVisible = true;
    }
    return isWebElementNotVisible;
  }

  protected BasePage getCurrentUrl(String url) {
    try {
      String currentUrl = driver.getCurrentUrl();
      if (!currentUrl.equals(url)) {
        Assert.assertTrue(false, "Wrong site page!");
      }
    } catch (IllegalStateException e) {
      e.printStackTrace();
    }
    return this;
  }

  protected WebElement fluentWaitForElementToBeClickable(WebElement webElement) {
    return new FluentWait<>(getDriver()).withTimeout(Duration.ofSeconds(Constants.FLUENT_WAITS_TIMEOUT_SECONDS))
        .pollingEvery(Duration.ofMillis(500))
        .ignoring(NoSuchElementException.class).until(ExpectedConditions.elementToBeClickable(webElement));

  }

  protected boolean fluentWaitForElementToBeNotVisible(WebElement webElement) {
    boolean isWebElementNotVisible = false;
    try {
      isWebElementNotVisible = new FluentWait<>(getDriver())
          .withTimeout(Duration.ofSeconds(2))
          .pollingEvery(Duration.ofMillis(200))
          .ignoring(NoSuchElementException.class)
          .until((ExpectedCondition<Boolean>) driver -> (!webElement.isDisplayed()));
    } catch (TimeoutException e) {
      isWebElementNotVisible = true;
    }
    return isWebElementNotVisible;
  }

  protected WebElement waitForElementToBeClickable(WebElement webElement) {
    return new WebDriverWait(getDriver(), Constants.WAIT_TIMEOUT_SECONDS).until(
        ExpectedConditions.elementToBeClickable(webElement));
  }

  protected WebElement waitForVisibilityOfElement(WebElement webElement) {
    return new WebDriverWait(getDriver(), Constants.WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
        .visibilityOf(webElement));
  }

  protected Optional<String> getValueInCollectionsElements(By elements, String value) {
    List<WebElement> elementsNameNftMarket = driver.findElements(elements);
    return elementsNameNftMarket
        .stream()
        .map(WebElement::getText)
        .filter(elementName -> elementName.equals(value))
        .findFirst();

  }

  protected Alert waitAlertIsPresent(Alert alert) {
    return new WebDriverWait(getDriver(), Constants.WAIT_TIMEOUT_SECONDS)
        .until(ExpectedConditions.alertIsPresent());
  }
}
