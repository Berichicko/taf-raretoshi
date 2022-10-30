package com.raretoshi.api.tests;

import com.raretoshi.api.listener.LogListenerApi;
import com.raretoshi.api.pojo.MessageFailedLogin;
import com.raretoshi.api.service.UserLoginService;
import com.raretoshi.api.utils.NewUser;
import com.raretoshi.api.utils.UserData;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({LogListenerApi.class})
public class LoginApiTest extends NewUser {

  private final String expectedErrorMessage = "Login failed";

  @Test
  public void testLoginUserEmptyNamePassword() {
    MessageFailedLogin messageFailedLogin = new UserLoginService()
        .postLoginUserWithNotCorrectData(NewUser.createNewUserNotValidEmptyNamePassword());
    Assert.assertEquals(expectedErrorMessage, messageFailedLogin.getMessage());

  }

  @Test
  public void testLoginUserNotValidNamePasswordRandomValues() {
    MessageFailedLogin messageFailedLogin = new UserLoginService()
        .postLoginUserWithNotCorrectData(NewUser.createNewUserNotValidNamePasswordRandomValues());
    Assert.assertEquals(expectedErrorMessage, messageFailedLogin.getMessage());

  }

  @Test
  public void testLoginUserNotValidEmailPasswordRandomValues() {
    MessageFailedLogin messageFailedLogin = new UserLoginService()
        .postLoginUserWithNotCorrectData(NewUser.createNewUserNotValidEmailPasswordRandomValues());
    Assert.assertEquals(expectedErrorMessage, messageFailedLogin.getMessage());

  }

  @Test
  public void testLoginUserCorrectEmailPassword() {
    UserLoginService userLoginService = new UserLoginService();
    String expectedEmailUserLogin = UserData.USER_EMAIL;
    String resultAuthUserEmail = userLoginService
        .postLoginUserWithCorrectData(NewUser.createNewUserCorrectEmailPassword());
    Assert.assertEquals(expectedEmailUserLogin, resultAuthUserEmail);

  }
}
