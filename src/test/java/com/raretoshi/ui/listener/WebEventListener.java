package com.raretoshi.ui.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class WebEventListener implements WebDriverEventListener {
    private static final Logger LOGGER = LogManager.getLogger(WebEventListener.class);

    public void beforeNavigateTo(String url, WebDriver driver) {
        LOGGER.info("Before navigating to: '" + url + "'");
    }

    public void afterNavigateTo(String url, WebDriver driver) {
        LOGGER.info("Navigated to:'" + url + "'");
    }

    public void beforeClickOn(WebElement element, WebDriver driver) {
        LOGGER.info("Trying to click on: " + element.toString());
    }

    public void afterClickOn(WebElement element, WebDriver driver) {
        LOGGER.info("Clicked on: " + element.toString());
    }

    public void beforeNavigateBack(WebDriver driver) {
        LOGGER.info("Navigating back to previous page");
    }

    public void afterNavigateBack(WebDriver driver) {
        LOGGER.info("Navigated back to previous page");
    }

    public void beforeNavigateForward(WebDriver driver) {
        LOGGER.info("Navigating forward to next page");
    }

    public void afterNavigateForward(WebDriver driver) {
        LOGGER.info("Navigated forward to next page");
    }

    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        LOGGER.info("Trying to find Element By : " + by.toString());
    }

    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        LOGGER.info("Found Element By : " + by.toString());
    }

    public void beforeScript(String script, WebDriver driver) {
    }

    public void afterScript(String script, WebDriver driver) {
    }

    public void beforeAlertAccept(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void afterAlertAccept(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void afterAlertDismiss(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void beforeAlertDismiss(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void beforeNavigateRefresh(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void afterNavigateRefresh(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        // TODO Auto-generated method stub

    }

    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        // TODO Auto-generated method stub

    }

    public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
        // TODO Auto-generated method stub

    }

    public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
        // TODO Auto-generated method stub

    }

    public void afterSwitchToWindow(String arg0, WebDriver arg1) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {

    }

    public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
        // TODO Auto-generated method stub

    }

    public void beforeGetText(WebElement arg0, WebDriver arg1) {
        // TODO Auto-generated method stub

    }

    public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
        // TODO Auto-generated method stub

    }
}
