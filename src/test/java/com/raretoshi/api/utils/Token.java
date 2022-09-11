package com.raretoshi.api.utils;

import com.raretoshi.api.model.User;
import com.raretoshi.api.pojo.Root;
import com.raretoshi.api.specification.Specifications;

import static io.restassured.RestAssured.given;

public class Token extends CreateUser {

    protected static String getToken() {
        Specifications.installSpecification(Specifications.requestSpecification(),
                Specifications.responseSpecification(200));
        User user = createNewUserCorrectEmailPassword();
        Root root = given()
                .body(user)
                .post(Endpoint.LOGIN_USER)
                .then()
                .log()
                .all()
                .extract()
                .body()
                .as(Root.class);
        return root.getJwt_token();
    }
}
