package Tests;

import Pages.LoginPage;
import Pages.NewPage;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static Pages.BasePage.logOut;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class LoginPageTest extends BaseTest {
    private LoginPage loginPage = new LoginPage();


    @Test
    public void checkLoginPageTest() {
        loginPage.open();
        loginPage.signIn("technopol32","technopolisPassword");
        NewPage newPage = new NewPage();
        Assertions.assertTrue(newPage.checkMoment(), "Открылась нужная страница");
        closeBrowser();
    }

    public void closeBrowser() {
        logOut();
        clearBrowserCache();
        Selenide.closeWebDriver();
    }

    @Test
    public void checkIncorrectLoginTest() {
        loginPage.open().signIn("qaa_test", "test");
        loginPage.checkIncorrectLogin();
        Selenide.closeWebDriver();
    }

    @Test
    public void checkIncorrectPassword() {
        loginPage.open().signIn("technopol32", "test");
        loginPage.checkIncorrectLogin();
    }

}
