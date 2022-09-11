package com.raretoshi.ui.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataProperties {

    public static String getDataProperties(String key) {
        FileInputStream fileInputStream;
        Properties property = new Properties();
        String host = null;
        String login = null;
        String password = null;
        try {
            fileInputStream = new FileInputStream("src/test/resources/config.properties");
            property.load(fileInputStream);
            host = property.getProperty("db.host");
            login = property.getProperty("db.login");
            password = property.getProperty("db.password");
              } catch (IOException e) {
            e.printStackTrace();
        }
        return property.getProperty(key);
    }
}
