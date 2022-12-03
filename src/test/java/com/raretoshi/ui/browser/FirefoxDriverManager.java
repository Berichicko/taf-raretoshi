package com.raretoshi.ui.browser;

import com.raretoshi.ui.utils.JsonReaderUtils;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager {

  private static final FirefoxOptions firefoxOptions = new FirefoxOptions();

  public static WebDriver createDriver() {
    WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
    setBrowserOptions();
    return new FirefoxDriver(firefoxOptions);
  }

  private static void setBrowserOptions() {

    if (Boolean.parseBoolean(JsonReaderUtils.getValueByKey("incognito_mode"))) {
      firefoxOptions.addArguments("-private");
    }
    if (Boolean.parseBoolean(JsonReaderUtils.getValueByKey("full_screen"))) {
      firefoxOptions.addArguments("--window-size=1280,1280");
    }
  }
}
