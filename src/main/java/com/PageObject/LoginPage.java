package com.PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class LoginPage {

    // кнопка Войти
    @FindBy(how = How.CSS, using = ".button_button_size_medium__3zxIa")
    private SelenideElement enterButton;

    //поле ввода email
    @FindBy(how = How.CSS, using = "fieldset:nth-child(1) input")
    private SelenideElement emailInput;

    //поле ввода password
    @FindBy(how = How.CSS, using = "fieldset:nth-child(2) input")
    private SelenideElement passwordInput;

    //кнопка "Восстановить пароль"
    @FindBy(how = How.XPATH, using = "//a[@href='/forgot-password']")
    private SelenideElement recoverPassButton;

    //title "Вход"
    @FindBy(how = How.XPATH, using = "//h2[text()='Вход']")
    private SelenideElement enterTitle;

    @Step("получить текст enterTitle")
    public String EnterTitle() {
        return enterTitle.shouldBe(Condition.exist).getText();
    }

    @Step("скролить до кнопки recoverPassButton")
    public void scrollToRecoverPassButton() {
        recoverPassButton.scrollTo();
    }

    @Step("клик по кнопке recoverPassButton")
    public void clickRecoverPassButton() {
        recoverPassButton.click();
    }

    @Step("заполнить поле password")
    public void setPassInput(String password) {
        passwordInput.setValue(password);
    }

    @Step("заполнить поле email")
    public void setEmailInput(String email) {
        emailInput.setValue(email);
    }

    @Step("клик по enterButton")
    public void clickEnterButton() {
        enterButton.click();
    }

    @Step("Логин курьера")
    public void logIn(String email, String pass) {
        setEmailInput(email);
        setPassInput(pass);
        clickEnterButton();
    }
}
