package com.raretoshi.api.specification;

import com.raretoshi.api.utils.Endpoint;
import com.raretoshi.api.utils.Token;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.http.ContentType.JSON;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class Specifications extends Token {
    private static final String AUTHORIZATION = "Authorization";
    private static final String BEARER = "Bearer ";

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .log(LogDetail.METHOD)
                .log(LogDetail.URI)
                .log(LogDetail.HEADERS)
                .log(LogDetail.BODY)
                .setBaseUri(Endpoint.BASE_URL)
                .setContentType(JSON)
                .setAccept(JSON)
                .build();
    }

    public static RequestSpecification requestSpecificationAuthUser() {
        return new RequestSpecBuilder()
                .log(LogDetail.STATUS)
                .setBaseUri(Endpoint.BASE_URL)
                .addHeader(AUTHORIZATION, BEARER + Token.getToken())
                .setContentType(JSON)
                .build();
    }

    public static ResponseSpecification responseSpecification(int statusCode) {
        return new ResponseSpecBuilder()
                .log(LogDetail.STATUS)
                .expectContentType(JSON)
                .expectStatusCode(statusCode)
                .expectResponseTime(lessThanOrEqualTo(3L), SECONDS)
                .build();
    }

    public static void installSpecification(RequestSpecification request, ResponseSpecification response) {
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }

}
