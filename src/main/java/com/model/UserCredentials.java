package com.model;

import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserCredentials extends ApiClient{

    private String baseURI = "/auth/login";

    @Step("Получение токена обновления")
    public String getUserAccessToken(User user) {
        String accessToken = "";
        Response response = given()
                .spec(getBaseSpec())
                .and()
                .body(user)
                .when()
                .post(baseURI);

        if (response.statusCode() == 200) {
            JsonPath path = response.jsonPath();

            String fullAccessToken = path.get("accessToken");
            int lastFileSeparatorIndex = fullAccessToken.lastIndexOf("Bearer ");
            accessToken = fullAccessToken.substring(lastFileSeparatorIndex + 7);
        }
        return accessToken;
    }
}
