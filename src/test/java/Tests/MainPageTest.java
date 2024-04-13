package Tests;

import Pages.MainPage;
import Pages.NewPage;
import org.junit.jupiter.api.*;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class MainPageTest extends BaseTest {
    private MainPage mainPage;

    @BeforeEach
    public void setup() {
        NewPage newPage = authorize();
        mainPage = newPage.openUserPage();
    }

    @Test
    @Tag("user")
    @DisplayName("Copy user's URL")
    public void copyUserURL() throws InterruptedException {
        Thread.sleep(5000);
        String userURl = "";
        try {
            userURl = mainPage.copyUrl();
        } catch (IOException | UnsupportedFlavorException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals("https://ok.ru/profile/586090035583?utm_campaign=web_share&utm_content=profile", userURl,
                "Ссылка скопирована правильно");
    }
}