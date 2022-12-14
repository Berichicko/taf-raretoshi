package com.raretoshi.ui.steps;

import com.raretoshi.ui.page.HomePage;
import com.raretoshi.ui.page.LoginPage;
import com.raretoshi.ui.utils.Random;
import com.raretoshi.ui.utils.UserCreator;

public class LoginStep {

  public static LoginPage getLoginWithEmptyCredentials() {
    return new LoginPage()
        .typeEmailUsername(Random.generateRandomAsciiString())
        .clearEmailUsername()
        .typePassword(Random.generateRandomAsciiString())
        .clearPassword()
        .clickButtonSubmit();
  }

  public static LoginPage getLoginWithEmptyPasswordCredentials() {
    return new LoginPage()
        .typeEmailUsername(Random.generateRandomAsciiString())
        .typePassword(Random.generateRandomAsciiString())
        .clearPassword()
        .clickButtonSubmit();
  }

  public static LoginPage getLoginWithEmptyUsernameEmailCredentials() {
    return new LoginPage()
        .typeEmailUsername(Random.generateRandomAsciiString())
        .clearEmailUsername()
        .typePassword(Random.generateRandomAsciiString())
        .clickButtonSubmit();
  }


  public static HomePage logIn() {
    return new HomePage()
        .clickSignIn()
        .authorize(UserCreator.createDefaultUser());

  }
}
