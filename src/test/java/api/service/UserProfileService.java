package api.service;

import api.model.ProfileUser;
import api.pojo.EditUserProfile;
import api.specification.Specifications;
import api.utils.ConstantsApi;
import static io.restassured.RestAssured.given;

public class UserProfileService {

    public EditUserProfile postEditProfileUserWithCorrectData(ProfileUser profileUser) {
        Specifications.installSpecification(Specifications.requestSpecificationAuthUser(),
                Specifications.responseSpecification(200));
         EditUserProfile editUserProfile = given()
                .body(profileUser)
                .post(ConstantsApi.postUrlUserProfile)
                .then()
                .log()
                .all()
                .extract()
                .as(EditUserProfile.class);
        return editUserProfile;
    }
}
