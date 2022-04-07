import com.PageObject.MainPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static com.model.ApiClient.mainPageURL;
import static org.junit.Assert.assertTrue;

public class TabsTest extends InitTest{

    @Before
    public void setUp() {
        Configuration.startMaximized = true;
    }

    @Test
    @DisplayName("Успешный переход к блоку начинки")
    public void checkSwitchToToppingsSectionTest() {
        MainPage mainPage = Selenide.open(mainPageURL, MainPage.class);
        mainPage.clickToppingsTab();
        boolean isFillingsTabActive = mainPage.isFillingsTabActive();
        assertTrue("Нет переключения на раздел Начинки при клике на таб Начинки", isFillingsTabActive);
    }

    @Test
    @DisplayName("Успешный переход к блоку начинки")
    public void checkSwitchToBunsSectionTest() {
        MainPage mainPage = Selenide.open(mainPageURL, MainPage.class);
        mainPage.clickBunsTab();
        boolean isBunsTabActive = mainPage.isBunsTabActive();
        assertTrue("Нет переключения на раздел Булки при клике на таб Булки", isBunsTabActive);
    }

    @Test
    @DisplayName("Успешный переход к блоку начинки")
    public void checkSwitchToSaucesSectionTest() {
        MainPage mainPage = Selenide.open(mainPageURL, MainPage.class);
        mainPage.clickSauceTab();
        boolean isSaucesTabActive = mainPage.isSaucesTabActive();
        assertTrue("Нет переключения на раздел Булки при клике на таб Булки", isSaucesTabActive);
    }
}
