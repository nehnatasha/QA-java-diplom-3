import com.PageObject.LoginPage;
import com.PageObject.RegistrationPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.model.User;
import com.model.UserClient;
import com.model.UserCredentials;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.model.ApiClient.registerPageURL;
import static org.junit.Assert.assertEquals;

public class RegistrationUserTest extends InitTest{

    UserClient userClient;
    User user;
    UserCredentials userCredentials;
    String expectedInvalidPassErrorMessage = "Некорректный пароль";
    String expectedEnterTitle = "Вход";

    @Before
    public void setUp() {
        userClient = new UserClient();
        userCredentials = new UserCredentials();
        Configuration.startMaximized = true;
    }

    @After
    public void tearDown() {
        webdriver().driver().close();
    }

    @DisplayName("Проверяем, что можно зарегистрироваться с паролем из 6 символов")
    @Test
    public void signUpWithSixCharacterPasswordPositiveTest() {
        user = User.getRandomCorrectUser();
        RegistrationPage registerPage = Selenide.open(registerPageURL, RegistrationPage.class);
        registerPage.signUp(user.name, user.email, user.password);

        LoginPage loginPage = Selenide.page(LoginPage.class);
        String actualEnterTitle = loginPage.EnterTitle();

        String accessToken = userCredentials.getUserAccessToken(user);
        userClient.delete(accessToken);

        assertEquals("Expected title is " + expectedEnterTitle + ". But actual is " + actualEnterTitle,
                expectedEnterTitle, actualEnterTitle);
    }

    @DisplayName("Проверяем, что можно зарегистрироваться с паролем из 7 символов")
    @Test
    public void signUpWithSevenSymbolsPassPositiveTest() {
        user = User.getUserWith7lettersPassword();
        RegistrationPage registerPage = Selenide.open(registerPageURL, RegistrationPage.class);
        registerPage.signUp(user.name, user.email, user.password);

        LoginPage loginPage = Selenide.page(LoginPage.class);
        String actualEnterTitle = loginPage.EnterTitle();

        String accessToken = userCredentials.getUserAccessToken(user);
        userClient.delete(accessToken);

        assertEquals("Expected title is " + expectedEnterTitle + ". But actual is " + actualEnterTitle,
                expectedEnterTitle, actualEnterTitle);
    }

    @DisplayName("Проверяет, что нельзя зарегистрироваться с паролем из 5 символов")
    @Test
    public void signUpWithFiveCharacterPassNegativeTest() {
        user = User.getUserWith5lettersPassword();
        RegistrationPage registerPage = Selenide.open(registerPageURL, RegistrationPage.class);
        registerPage.signUp(user.name, user.email, user.password);

        String actualErrorMessage = registerPage.getTooShortPasswordErrorMessage();

        assertEquals("Expected error message is " + expectedInvalidPassErrorMessage + ". But actual is " + actualErrorMessage,
                expectedInvalidPassErrorMessage, actualErrorMessage);
    }
}
