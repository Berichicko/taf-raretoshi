package com.raretoshi.api.service;

import com.raretoshi.api.model.User;
import com.raretoshi.api.pojo.MessageFailedLogin;
import com.raretoshi.api.pojo.SuccessLogInUser;
import com.raretoshi.api.specification.Specifications;
import com.raretoshi.api.utils.Endpoint;
import static io.restassured.RestAssured.given;

public class UserLoginService {

    public MessageFailedLogin postLoginUserWithNotCorrectData(User user) {
        Specifications.installSpecification(Specifications.requestSpecification(),
                Specifications.responseSpecification(500));
        return given()
                .body(user)
                .post(Endpoint.LOGIN_USER)
                .then()
                .log()
                .all()
                .extract()
                .as(MessageFailedLogin.class);
    }

    public String postLoginUserWithCorrectData(User user) {
        Specifications.installSpecification(Specifications.requestSpecification(),
                Specifications.responseSpecification(200));
        SuccessLogInUser successLogInUser = given()
                .body(user)
                .post(Endpoint.LOGIN_USER)
                .then()
                .log()
                .all()
                .extract()
                .body()
                .jsonPath()
                .getObject("user", SuccessLogInUser.class);
        return successLogInUser.getEmail();

    }
}
