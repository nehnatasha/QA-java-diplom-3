import com.PageObject.LoginPage;
import com.PageObject.MainPage;
import com.PageObject.ProfilePage;
import com.PageObject.RegistrationPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.model.User;
import com.model.UserClient;
import com.model.UserCredentials;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.model.ApiClient.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertTrue;

public class LogInUserTest extends InitTest{

    UserClient userClient;
    User user;
    UserCredentials userCredentials;

    @Before
    public void setUp() {
        userClient = new UserClient();
        userCredentials = new UserCredentials();
        user = User.getRandomCorrectUser();
        Response response = userClient.userRegistration(user);
        response.then()
                .assertThat()
                .statusCode(200)
                .and()
                .body("success", equalTo(true));
        Configuration.startMaximized = true;
    }

    @After
    public void tearDown() {
        MainPage mainPage = Selenide.open(mainPageURL, MainPage.class);
        mainPage.clickPersonalAccountButton();

        ProfilePage personalAccountPage = Selenide.page(ProfilePage.class);
        personalAccountPage.clickExitButton();

        webdriver().driver().close();

        String accessToken = userCredentials.getUserAccessToken(user);
        userClient.delete(accessToken);
    }

    @DisplayName("Логин при клике на кнопку Войти на Главной странице")
    @Test
    public void logInByClickingEnterToAccountButtonTest() {

        MainPage mainPage = Selenide.open(mainPageURL, MainPage.class);
        mainPage.clickLogInToAccountButton();

        LoginPage loginPage = Selenide.page(LoginPage.class);
        loginPage.logIn(user.email, user.password);

        boolean setUpBurgerTitle = mainPage.isSetUpBurgerTitleDisplayed();
        assertTrue("Logo 'Собери бургер' is not displayed", setUpBurgerTitle);
    }

    @DisplayName("Логин при клике на кнопку Личный Аккаунт на Главной странице")
    @Test
    public void logInByClickingPersonalAccountButtonTest() {

        MainPage mainPage = Selenide.open(mainPageURL, MainPage.class);
        mainPage.clickPersonalAccountButton();

        LoginPage loginPage = Selenide.page(LoginPage.class);
        loginPage.logIn(user.email, user.password);

        mainPage.scroolToSetUpBurgerTitle();
        boolean setUpBurgerTitle = mainPage.isSetUpBurgerTitleDisplayed();
        assertTrue("Logo 'Собери бургер' is not displayed", setUpBurgerTitle);
    }

    @DisplayName("Логин при клике на кнопку Войти на странице Регистрации")
    @Test
    public void logInByClickingEnterButtonOnRegistrationPageTest() {

        RegistrationPage registerPage = Selenide.open(registerPageURL, RegistrationPage.class);
        registerPage.scrollToRegistrationPageEnterButton();
        registerPage.clickRegistrationPageEnterButton();

        LoginPage loginPage = Selenide.page(LoginPage.class);
        loginPage.logIn(user.email, user.password);

        MainPage mainPage = Selenide.page(MainPage.class);
        mainPage.scroolToSetUpBurgerTitle();
        boolean setUpBurgerTitle = mainPage.isSetUpBurgerTitleDisplayed();

        assertTrue("Лого 'Собери бургер' не отображается", setUpBurgerTitle);
    }

}
