package com.raretoshi.ui.listener;

import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import java.lang.annotation.Annotation;
import java.util.List;

import static java.util.Arrays.asList;

public class UtilsListenerUi {

    public boolean shouldIntercept(ITestResult result) {
        List<String> listeners = result.getTestContext().getCurrentXmlTest().getSuite().getListeners();
        return listeners.contains(this.getClass().getName()) || shouldIntercept(result.getTestClass().getRealClass(), this.getClass());
    }

    public boolean shouldIntercept(Class testClass, Class annotation) {
        Listeners listenersAnnotation = getListenersAnnotation(testClass);
        return listenersAnnotation != null && asList(listenersAnnotation.value()).contains(annotation);
    }

    private Listeners getListenersAnnotation(Class testClass) {
        Annotation annotation = testClass.getAnnotation(Listeners.class);
        return annotation != null ? (Listeners) annotation :
                testClass.getSuperclass() != null ? getListenersAnnotation(testClass.getSuperclass()) : null;
    }

}
