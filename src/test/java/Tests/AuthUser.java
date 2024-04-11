package Tests;

import org.junit.jupiter.api.*;
import Pages.NewPage;
import Pages.MainPage;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class AuthUser extends BaseTest {
    private MainPage authPage;

    @BeforeEach
    public void setup() {
        NewPage newsPage = authorize();
        authPage = newsPage.openUserPage();
    }

    @Test
    @Tag("user")
    @DisplayName("Copy user's URL")
    public void copyUserURL() {
        String userURl = "";
        try {
            userURl = authPage.copyUrl();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals("https://ok.ru/profile/586489906527?utm_campaign=web_share&utm_content=profile", userURl,
                "Ссылка скопирована неправильно");
    }
}