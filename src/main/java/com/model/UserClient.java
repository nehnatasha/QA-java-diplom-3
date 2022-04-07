package com.model;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient extends ApiClient{

    @Step("Регистрация курьера")
    public Response userRegistration(User user) {
        return given()
                .spec(getBaseSpec())
                .and()
                .body(user)
                .when()
                .post("/auth/register");
    }

    @Step("Удаление клиента")
    public void delete(String authentication) {
        if (authentication == null) {
            return;
        }
        given()
                .headers(
                        "Authorization", "Bearer " + authentication,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .spec(getBaseSpec())
                .when()
                .delete("auth/user")
                .then()
                .statusCode(202);
    }
}
