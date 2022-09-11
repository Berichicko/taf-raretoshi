package com.raretoshi.api.listener;

import io.qameta.allure.Attachment;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LogListenerApi extends UtilsListenerApi implements ITestListener {
    private final Logger LOGGER = LogManager.getLogger();
    private final ByteArrayOutputStream request = new ByteArrayOutputStream();
    private final ByteArrayOutputStream response = new ByteArrayOutputStream();
    private final PrintStream requestVar = new PrintStream(request, true);
    private final PrintStream responseVar = new PrintStream(response, true);

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    public void onStart(ITestContext iTestContext) {
        LOGGER.info("I am in onStart method " + iTestContext.getName());
        RestAssured.filters(new ResponseLoggingFilter(LogDetail.ALL, responseVar),
                new RequestLoggingFilter(LogDetail.ALL, requestVar));

    }

    public void onTestSuccess(ITestResult iTestResult) {
        if (shouldIntercept(iTestResult)) {
            LOGGER.info("I am in onTestMethod " + getTestMethodName(iTestResult));
            logRequest(request);
            logResponse(response);
        }
    }

    public void onTestFailure(ITestResult iTestResult) {
        onTestSuccess(iTestResult);
    }

    @Attachment(value = "request")
    public byte[] logRequest(ByteArrayOutputStream stream) {
        return attach(stream);
    }

    @Attachment(value = "response")
    public byte[] logResponse(ByteArrayOutputStream stream) {
        return attach(stream);
    }

    public byte[] attach(ByteArrayOutputStream log) {
        byte[] array = log.toByteArray();
        log.reset();
        return array;
    }

    public void onTestStart(ITestResult iTestResult) {
        LOGGER.info("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
    }

    public void onTestSkipped(ITestResult iTestResult) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    public void onFinish(ITestContext iTestContext) {
        LOGGER.info("I am in onFinish method " + iTestContext.getName());
    }
}
