package Tests;

import Pages.MainPage;
import Pages.NewPage;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

import static Pages.BasePage.logOut;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class OpenMessengerTest extends BaseTest {
    private MainPage mainPage;
    private NewPage newPage;

    @BeforeEach
    public void setup() {
        NewPage newsPage = authorize();
        mainPage = newsPage.openUserPage();
    }

    @Test
    @Tag("Messenger")
    public void clickOpenMessenger() {
        mainPage.clickMessenger();
        mainPage.setText("technopol42");
        Assertions.assertTrue(mainPage.checkOpenMessenger(), "Мессенджер открывается");
    }

    @AfterEach
    public void closeBrowser() {
        logOut();
        clearBrowserCache();
        Selenide.closeWebDriver();
    }
}
