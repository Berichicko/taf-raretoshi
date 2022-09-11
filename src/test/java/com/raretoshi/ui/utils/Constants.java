package com.raretoshi.ui.utils;

public class Constants {
    public static final String BASE_URL = DataProperties.getDataProperties("db.host");
    public static final String PROFILE_USER_URL = BASE_URL + Random.USER_NAME;
    public static final String LOGIN_URL = BASE_URL+"login";

}
