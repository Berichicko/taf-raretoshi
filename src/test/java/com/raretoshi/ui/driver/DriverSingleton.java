package com.raretoshi.ui.driver;

import com.raretoshi.ui.listener.WebEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class DriverSingleton {

  private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
  protected static WebDriver driver;

  public static WebDriver initializeDriver() {
    if (driver == null) {
      WebDriverManager.chromedriver()
          .setup();
      ChromeOptions chromeOptions = new ChromeOptions()
          .addArguments( "--start-maximized","--incognito");
      driver = new ChromeDriver(chromeOptions);
      EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
      eventFiringWebDriver.register(new WebEventListener());
      threadLocalDriver.set(eventFiringWebDriver);

    }
    return getDriver();
  }

  public static synchronized WebDriver getDriver() {
    return threadLocalDriver.get();
  }

  public static void closeDriver() {
    driver.quit();
    driver = null;
  }
}
