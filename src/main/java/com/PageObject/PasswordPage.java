package com.PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class PasswordPage {

    @FindBy(how = How.XPATH,using = "//a[@class='Auth_link__1fOlj'][text()='Войти']")
    private SelenideElement loginLink;

    @Step("Клик по ссылке 'Войти'")
    public void clickLoginLink() {
        loginLink.click();
    }
}
