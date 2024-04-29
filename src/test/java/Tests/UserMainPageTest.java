package Tests;

import Pages.UserMainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static Pages.BasePage.logOut;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static java.time.Duration.ofMillis;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserMainPageTest extends BaseTest {
    private UserMainPage userMainPage;

    @BeforeEach
    public void setup() {
        authorize();
    }

    @Test
    @Tag("User_test")
    public void copyUserURL() throws IOException, UnsupportedFlavorException {
        UserMainPage.openUserPage();
        String userURl;
        userURl = UserMainPage.copyUrl();
        Assertions.assertEquals("https://ok.ru/profile/586090035583?utm_campaign=web_share&utm_content=profile", userURl,
                "Ссылка скопирована неправильно");
        assertThatThrownBy(() ->
                webdriver().shouldHave(url("https://ok.ru/profile/586090035583?utm_campaign=web_share&utm_content=profile"), ofMillis(10)));
        logOut();
    }


}
