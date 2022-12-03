package com.raretoshi.ui.browser;

import com.raretoshi.ui.utils.JsonReaderUtils;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager {

  private static final ChromeOptions chromeOptions = new ChromeOptions();

  public static WebDriver createDriver() {

    WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
    setBrowserOptions();
    return new ChromeDriver(chromeOptions);
  }

  private static void setBrowserOptions() {

    if (Boolean.parseBoolean(JsonReaderUtils.getValueByKey("incognito_mode"))) {
      chromeOptions.addArguments("--incognito");
    }
    if (Boolean.parseBoolean(JsonReaderUtils.getValueByKey("full_screen"))) {
      chromeOptions.addArguments("--start-maximized");
    }
  }
}
