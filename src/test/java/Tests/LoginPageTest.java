package Tests;

import Pages.LoginPage;
import Pages.NewPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static Pages.BasePage.logOut;

public class LoginPageTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();


    @Test
    public void checkLoginPageTest() {
        loginPage.open();
        loginPage.signIn("technopol32", "technopolisPassword");
        NewPage newPage = loginPage.login();
        Assertions.assertTrue(newPage.checkMoment(), "Авторизация прошла");
        logOut();
    }

    @Test
    public void checkIncorrectLoginTest() {
        loginPage.open().signIn("qaa_test", "test");
        loginPage.pushLogin();
        Assertions.assertFalse(loginPage.checkIncorrectLogin(), "Авторизация не прошла");
    }

    @Test
    public void checkIncorrectPassword() {
        loginPage.open().signIn("technopol32", "test");
        loginPage.pushLogin();
        loginPage.checkIncorrectLogin();
        Assertions.assertFalse(loginPage.checkIncorrectLogin(), "Авторизация не прошла");
    }

}
