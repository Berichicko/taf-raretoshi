package com.raretoshi.ui;

import com.raretoshi.ui.driver.DriverSingleton;
import com.raretoshi.ui.listener.LogListenerUi;
import com.raretoshi.ui.page.HomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(LogListenerUi.class)
public class BaseTest {

    @BeforeMethod
    public void openHomePage() {
        new HomePage().openPage();
    }

    @AfterMethod(alwaysRun = true)
    public void finishTest() {
        DriverSingleton.closeDriver();
    }
}
