package com.model;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.http.ContentType.JSON;

public class ApiClient {

    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site/api/";
    public static final String mainPageURL = "https://stellarburgers.nomoreparties.site/";
    public static final String registerPageURL = "https://stellarburgers.nomoreparties.site/register";
    public static final String loginURL = "https://stellarburgers.nomoreparties.site/login";


    public static RequestSpecification getBaseSpec() {
        return new RequestSpecBuilder()
                .setContentType(JSON)
                .setBaseUri(BASE_URL)
                .build();
    }
}
