package com.PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfilePage {

    // кнопка Конструктор
    @FindBy(how = How.XPATH, using = "//p[text()='Конструктор']")
    private SelenideElement constructorButton;

    // Лого Stellar burger header
    @FindBy(how = How.CSS, using = ".AppHeader_header__logo__2D0X2")
    private SelenideElement headerLogo;

    // кнопка Выход
    @FindBy(how = How.CSS, using = ".Account_button__14Yp3")
    private SelenideElement exitButton;

    // кнопка Профиль
    @FindBy(how = How.XPATH, using = "//a[text()='Профиль']")
    private SelenideElement profileButton;

    public void clickConstructorButton() {
        constructorButton.click();
    }

    public void clickStellarBurgerHeaderLogo() {
        headerLogo.click();
    }

    public boolean isProfileButtonDisplayed() {
        return profileButton.shouldBe(Condition.exist).isDisplayed();
    }

    public boolean isExitButtonDisplayed() {
        return exitButton.shouldBe(Condition.exist).isDisplayed();
    }

    public void clickExitButton() {
        exitButton.click();
    }
}
