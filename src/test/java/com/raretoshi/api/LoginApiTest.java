package com.raretoshi.api;

import com.raretoshi.api.listener.LogListenerApi;
import com.raretoshi.api.model.User;
import com.raretoshi.api.pojo.MessageFailedLogin;
import com.raretoshi.api.service.UserLoginService;
import com.raretoshi.api.utils.CreateUser;
import com.raretoshi.api.utils.UserData;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({LogListenerApi.class})
public class LoginApiTest extends CreateUser {
    private String expectedErrorMessage = "Login failed";

    @Test
    public void testLoginUserEmptyNamePassword() {
        User user = createNewUserNotValidEmptyNamePassword();
        MessageFailedLogin messageFailedLogin = new UserLoginService().postLoginUserWithNotCorrectData(user);
        Assert.assertEquals(expectedErrorMessage, messageFailedLogin.getMessage());

    }

    @Test
    public void testLoginUserNotValidNamePasswordRandomValues() {
        User user = createNewUserNotValidNamePasswordRandomValues();
        MessageFailedLogin messageFailedLogin = new UserLoginService().postLoginUserWithNotCorrectData(user);
        Assert.assertEquals(expectedErrorMessage, messageFailedLogin.getMessage());

    }

    @Test
    public void testLoginUserNotValidEmailPasswordRandomValues() {
        User user = createNewUserNotValidEmailPasswordRandomValues();
        MessageFailedLogin messageFailedLogin = new UserLoginService().postLoginUserWithNotCorrectData(user);
        Assert.assertEquals(expectedErrorMessage, messageFailedLogin.getMessage());

    }

    @Test
    public void testLoginUserCorrectEmailPassword() {
        UserLoginService userLoginService = new UserLoginService();
        String expectedEmailUserLogin = UserData.USER_EMAIL;
        User user = createNewUserCorrectEmailPassword();
        String resultAuthUserEmail = userLoginService.postLoginUserWithCorrectData(user);
        Assert.assertEquals(expectedEmailUserLogin, resultAuthUserEmail);

    }
}
