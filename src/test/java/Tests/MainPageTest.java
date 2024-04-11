package Tests;

import Pages.LoginPage;
import Pages.MainPage;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;
import Pages.NewPage;
import Pages.MainPage;
import Pages.BasePage;

import static Pages.BasePage.logOut;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class MainPageTest extends BaseTest {
    private NewPage newPage;

    MainPage mainPage = new MainPage();

    @BeforeEach
    public void setup() {
        newPage = authorize();
    }
    @Test
    public void clickOpenMessenger(){
        mainPage.openLoggedIn();
        mainPage.clickMessenger();
    }
    @Test
    public void playMusic() throws InterruptedException {
        mainPage.openLoggedIn();
        mainPage.setPlayMusic();
        TimeUnit.SECONDS.sleep(3);
    }
    @Test
    public void playVideoTest() throws InterruptedException {
        mainPage.setPlayVideo();
        TimeUnit.SECONDS.sleep(5);
    }
    @AfterEach
    public void closeBrowser() {
        logOut();
        clearBrowserCache();
        Selenide.closeWebDriver();
    }
}
