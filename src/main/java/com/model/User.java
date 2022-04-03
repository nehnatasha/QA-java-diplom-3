package com.model;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;

public class User extends ApiClient {

    public String email;
    public String password;
    public String name;

    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    @Step("Получение корректного пользователя")
    public static User getRandomCorrectUser() {
        final String email = (RandomStringUtils.randomAlphabetic(10) + "@gmail.com").toLowerCase();
        final String password = RandomStringUtils.randomAlphabetic(10).toLowerCase();
        final String name = RandomStringUtils.randomAlphabetic(10).toLowerCase();
        return new User(email, password, name);
    }

    @Step("Получение  пользователя c паролем в 7 символов")
    public static User getUserWith7lettersPassword() {
        final String email = RandomStringUtils.randomAlphabetic(10) + "@gmail.com";
        final String password = RandomStringUtils.randomAlphabetic(7);
        final String name = RandomStringUtils.randomAlphabetic(10).toLowerCase();
        return new User(email, password, name);
    }

    @Step("Получение  пользователя c паролем в 5 символов")
    public static User getUserWith5lettersPassword() {
        final String email = RandomStringUtils.randomAlphabetic(10) + "@gmail.com";
        final String password = RandomStringUtils.randomAlphabetic(5);
        final String name = RandomStringUtils.randomAlphabetic(5);
        return new User(email, password, name);
    }

    @Step("Получение  пользователя без почты")
    public static User getUserWithOutEmail() {
        final String password = RandomStringUtils.randomAlphabetic(10);
        final String name = RandomStringUtils.randomAlphabetic(10);
        return new User(null, password, name);
    }
}
