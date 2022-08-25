package ui.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSingleton {
    private static ThreadLocal<WebDriver> tdriver  = new ThreadLocal<WebDriver>();
    protected static WebDriver driver;
    private static ChromeOptions chromeOptions;

    private DriverSingleton() {
    }

    public static WebDriver initializeDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver()
                    .setup();
            chromeOptions = new ChromeOptions()
                    .addArguments("--headless")
                    .addArguments("--window-size=1920,1200");
            driver = new ChromeDriver(chromeOptions);

            tdriver.set(driver);

        }
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tdriver.get();
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
