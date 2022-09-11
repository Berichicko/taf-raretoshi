package com.raretoshi.ui.listener;

import com.raretoshi.ui.driver.DriverSingleton;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class LogListenerUi extends UtilsListenerUi implements ITestListener {
    private final Logger LOGGER = LogManager.getLogger();

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    @Attachment
    public byte[] saveFailureScreenShot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        LOGGER.info("I am in onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", DriverSingleton.getDriver());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        LOGGER.info("I am in onFinish method " + iTestContext.getName());
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        LOGGER.info("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LOGGER.info("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        if (shouldIntercept(iTestResult)) {
            LOGGER.error("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
            WebDriver driver = DriverSingleton.getDriver();
            if (driver instanceof WebDriver) {
                LOGGER.info("Screenshot captured for test case:" + getTestMethodName(iTestResult));
                saveFailureScreenShot(driver);
            }
            saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        LOGGER.info("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        LOGGER.error("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }

}
