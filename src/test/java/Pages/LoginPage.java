package Pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private static final By LOGIN_INPUT = By.xpath("//*[@id='field_email']");
    private static final By PASSWORD_INPUT = By.xpath("//*[@id='field_password']");
    private static final By LOGIN_BUTTON = By.xpath("//input[@class='button-pro __wide']");
    private static final By LOGIN_ERROR_TEXT = By.xpath("//div[@class='input-e login_error']");
    private static final By BUTTON_AUTH = By.xpath("//*[@data-l='t,login_tab']");
    private static final By FORM_AUTH = By.xpath("//*[contains(@class,'tab-body')]");
    private static final By RETURN_BUTTON = By.xpath("//*[@data-l='t,cancel']");


    public LoginPage() {

        checkLoginPage();
    }

    public static void setName(String name) {
        $(LOGIN_INPUT).shouldBe(visible.because("Login field should be visible for users to set login")).setValue(name);
        $(LOGIN_INPUT).shouldHave(value(name));
    }

    public static void setPassword(String password) {
        $(PASSWORD_INPUT).shouldBe(visible.because("Password field should be visible for users to set password")).setValue(password);
        $(PASSWORD_INPUT).shouldHave(value(password));
    }

    public static void enterButton() {
        $(LOGIN_BUTTON).shouldBe(visible.because("Login button should be visible to enter")).click();
        //Если не видна, то $(RETURN_BUTTON).shouldBe(visible.because("The back button should be visible to return to the login page")).click();
    }

    private void checkLoginPage() {
        $(LOGIN_INPUT).shouldBe(visible.because("Login field should be visible on login page"));
        $(PASSWORD_INPUT).shouldBe(visible.because("Password field should be visible on login page"));
        $(LOGIN_BUTTON).shouldBe(visible.because("Login button should be visible to enter"));
        $(BUTTON_AUTH).shouldBe(visible.because("Authorization button should be on login page"));
        $(FORM_AUTH).shouldBe(visible.because("Authorization form should be on login page"));
    }

    public void signIn(String login, String password) {
        $(LOGIN_INPUT).shouldBe(visible.because("Login field should be visible for users to set login")).setValue(login);
        $(PASSWORD_INPUT).shouldBe(visible.because("Password field should be visible for users to set password")).setValue(password);
        $(LOGIN_BUTTON).shouldBe(visible.because("Login button should be visible to enter")).click();
    }

    public boolean checkIncorrectLogin() {
        $(LOGIN_ERROR_TEXT).shouldBe(visible.because("The TEXT OF THE LOGIN ERROR should be on the incorrect authorization page")).shouldHave(text("Неправильно указан логин и/или пароль"));
        return false;
    }

}