package Tests;

import Pages.LoginPage;
import Pages.MainPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class MainPageTest extends BaseTest {


    MainPage mainPage = new MainPage();

    @Test
    public void checkSignInTest() {

        mainPage.openLoggedIn().checkMainPage();
    }

    @Test
    public void clickOpenMessenger(){
        mainPage.openLoggedIn().checkMainPage();
        mainPage.clickMessenger();
    }
    @Test
    public void playMusic() throws InterruptedException {
        mainPage.openLoggedIn().checkMainPage();
        mainPage.setPlayMusic();
        TimeUnit.SECONDS.sleep(3);
    }
    @Test
    public void playVideoTest() throws InterruptedException {
        mainPage.openLoggedIn().checkMainPage();
        mainPage.setPlayVideo();
        TimeUnit.SECONDS.sleep(5);
    }

}
