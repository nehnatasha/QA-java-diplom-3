package com.PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.*;

public class MainPage {

    // кнопка "Войти в аккаунт"
    @FindBy(how = How.CSS,using = ".button_button__33qZ0")
    private SelenideElement logInButton;

    // Лого "Соберите бургер"
    @FindBy(how = How.XPATH,using = "//h1[text()='Соберите бургер']")
    private SelenideElement setUpBurgerTitle;

    // кнопка персонального аккаунта
    @FindBy(how = How.CSS,using = ".AppHeader_header__link__3D_hX:nth-child(3) .AppHeader_header__linkText__3q_va")
    private SelenideElement personalAccountButton;

    // вкладка Булки
    @FindBy(how = How.CSS,using = ".tab_tab__1SPyG:nth-child(1)")
    private SelenideElement bunsTab;

    // текст Булки
    @FindBy(how = How.CSS,using = ".text_type_main-medium:nth-child(1)")
    private SelenideElement bunsTitle;

    // вкладка Соусы
    @FindBy(how = How.CSS,using = ".tab_tab__1SPyG:nth-child(2)")
    private SelenideElement saucesTab;

    // текст Соус
    @FindBy(how = How.CSS,using = ".text:nth-child(3)")
    private SelenideElement saucesTitle;

    // вкладка Начинки
    @FindBy(how = How.CSS,using = ".tab_tab__1SPyG:nth-child(3)")
    private SelenideElement toppingsTab;

    // текст Начинки
    @FindBy(how = How.CSS,using = ".text:nth-child(5)")
    private SelenideElement toppingsTitle;

    // весь блок "Булки"
    @FindBy(how = How.CSS,using = ".BurgerIngredients_ingredients__menuContainer__Xu3Mo > ul:nth-child(2)")
    private SelenideElement bunsSection;

    // весь блок "Соусы"
    @FindBy(how = How.CSS,using = ".BurgerIngredients_ingredients__menuContainer__Xu3Mo > ul:nth-child(4)")
    private SelenideElement saucesSection;

    // весь блок "Начинки"
    @FindBy(how = How.CSS,using = ".BurgerIngredients_ingredients__menuContainer__Xu3Mo > ul:last-child")
    private SelenideElement toppingsSection;

    // сохраняем в переменную класс, который есть только у выбранного таба
    @FindBy(how = How.CSS,using = ".tab_tab_type_current__2BEPc")
    public SelenideElement currentActiveSection;

    @Step("вытаскиваем текст активного таба (Начинки)")
    public boolean isFillingsTabActive() {
        return currentActiveSection.getText().contentEquals("Начинки");
    }

    @Step("вытаскиваем текст активного таба (Соусы)")
    public boolean isSaucesTabActive() {
        return currentActiveSection.getText().contentEquals("Соусы");
    }

    @Step("вытаскиваем текст активной вкладки (Булки)")
    public boolean isBunsTabActive() {
        return currentActiveSection.getText().contentEquals("Булки");
    }

    @Step("клик на вкладку \"Булки\"")
    public void clickBunsTab() {
        bunsTab.shouldBe(enabled).doubleClick();
    }

    @Step("клик на вкладку \"Соусы\"")
    public void clickSauceTab() {
        saucesTab.shouldBe(enabled).click();
    }

    @Step("клик на вкладку \"Начинки\"")
    public void clickToppingsTab() {
        toppingsTab.click();
    }

    @Step("клик \"Войти в аккаунт\"")
    public void clickPersonalAccountButton() {
        personalAccountButton.shouldBe(Condition.exist).click();
    }

    @Step("scroll to \"Соберите бургер\" title")
    public void scroolToSetUpBurgerTitle() {
        setUpBurgerTitle.scrollTo().shouldBe(visible);
    }

    @Step("returns true if title \"Соберите бургер\" is displayed")
    public boolean isSetUpBurgerTitleDisplayed() {
        return setUpBurgerTitle.shouldBe(visible).isDisplayed();
    }

    @Step("clicks Войти в аккаунт button")
    public void clickLogInToAccountButton() {
        logInButton.shouldBe(Condition.exist).click();
    }

}