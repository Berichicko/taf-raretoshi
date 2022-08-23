package api;

import api.model.ProfileUser;
import api.pojoobject.EditUserProfile;
import api.service.UserProfileService;
import api.utils.CreateUserProfile;
import org.testng.Assert;
import org.testng.annotations.Test;



public class ProfileApiTest extends CreateUserProfile {

    @Test
    public void testProfileUserCorrectValues() {
        ProfileUser profileUser = createUserProfileWithCorrectCredentials();
        EditUserProfile editUserProfile = new UserProfileService().postEditProfileUserWithCorrectData(profileUser);
        Assert.assertEquals("romUnARbAh@gmail.com",profileUser.getEmail());



    }

}
