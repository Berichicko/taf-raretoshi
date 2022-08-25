package ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import ui.driver.DriverSingleton;
import ui.listener.TestListener;
import ui.page.HomePage;

@Listeners({TestListener.class})
public class BaseTest {
    protected static final Logger logger = LogManager.getLogger();

    @BeforeMethod
    public void openHomePageTest() {
        new HomePage().openPage();
    }

    @AfterMethod (alwaysRun = true)
    public void finishTest() {
        DriverSingleton.closeDriver();
    }

}
