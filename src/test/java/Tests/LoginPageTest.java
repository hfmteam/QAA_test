package Tests;

import Pages.LoginPage;
import Pages.UserMainPage;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static Pages.BasePage.logOut;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class LoginPageTest extends BaseTest {


    @AfterAll
    public static void closeBrowser() {
        clearBrowserCache();
        Selenide.closeWebDriver();
    }

    @Test
    @Tag("Check_Login_Page")
    public void checkLoginPageTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.signIn("technopol32", "technopolisPassword");
        UserMainPage userMainPage = new UserMainPage();
        Assertions.assertTrue(userMainPage.checkMoment(), "Авторизация прошла");
        logOut();
    }

    @ParameterizedTest
    @Tag("Incorrect_Login_Test")
    @CsvSource({
            "qaa_test, test",
            "technopol32, test"
    })
    public void checkIncorrectLoginTest(String login, String password) {
        LoginPage.setName(login);
        LoginPage.setPassword(password);
        LoginPage.enterButton();
        LoginPage loginPage = new LoginPage();
        Assertions.assertFalse(loginPage.checkIncorrectLogin(), "Авторизация не прошла");
    }
}
