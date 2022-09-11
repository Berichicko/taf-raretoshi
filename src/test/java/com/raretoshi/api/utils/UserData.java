package com.raretoshi.api.utils;

import com.raretoshi.ui.utils.DataProperties;

public class UserData {
    public static final String USER_EMAIL = DataProperties.getDataProperties("db.login");
    public static final String PASSWORD = DataProperties.getDataProperties("db.password");
}
