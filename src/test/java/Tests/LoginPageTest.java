package Tests;

import Pages.LoginPage;
import org.junit.jupiter.api.Test;

public class LoginPageTest extends BaseTest {
    LoginPage loginPage = new LoginPage();

    @Test
    public void checkLoginPageTest() {
        loginPage.open().checkLoginPage();
    }

    @Test
    public void checkIncorrectLoginTest() {
        loginPage.open().signIn("qaa_test", "test");
        loginPage.checkIncorrectLogin();
    }

    @Test
    public void checkIncorrectPassword() {
        loginPage.open().signIn("technopol32", "test");
        loginPage.checkIncorrectLogin();
    }

}
