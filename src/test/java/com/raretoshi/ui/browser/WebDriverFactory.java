package com.raretoshi.ui.browser;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManagerException;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

  public static WebDriver createDriver(DriverManagerType type) {
    switch (type) {
      case FIREFOX:
        return FirefoxDriverManager.createDriver();
      case CHROME:
        return ChromeDriverManager.createDriver();
      default:
        throw new WebDriverManagerException("IUnexpected browser");
    }
  }
}
