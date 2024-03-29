package com.raretoshi.ui.driver;

import com.raretoshi.ui.browser.WebDriverFactory;
import com.raretoshi.ui.listener.WebEventListener;
import com.raretoshi.ui.utils.JsonReaderUtils;
import io.github.bonigarcia.wdm.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class DriverSingleton {

  private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
  private static WebDriver driver;

  public static WebDriver initializeDriver() {
    if (driver == null) {
      driver = WebDriverFactory.createDriver(DriverManagerType.valueOf(JsonReaderUtils.getValueByKey("browser_name").toUpperCase()));
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
