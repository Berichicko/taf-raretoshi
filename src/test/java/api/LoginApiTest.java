package api;

import api.model.User;
import api.pojo.MessageFailedLogin;
import api.service.UserLoginService;
import api.utils.ConstantsApi;
import api.utils.CreateUser;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.listener.TestListener;

@Listeners({TestListener.class})
public class LoginApiTest extends CreateUser {
    String expectedErrorMessage = "Login failed";

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
    public void testLoginUserUserCorrectEmailPassword() {
        UserLoginService userLoginService = new UserLoginService();
        String expectedEmailUserLogin = ConstantsApi.USER_EMAIL;
        User user = createNewUserCorrectEmailPassword();
        String resultAuthUserEmail = userLoginService.postLoginUserWithCorrectData(user);
        Assert.assertEquals(expectedEmailUserLogin, resultAuthUserEmail);

    }
}
