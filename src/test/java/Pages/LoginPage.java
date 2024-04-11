package Pages;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;


import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private static final By loginInput = By.xpath(".//*[@id='field_email']");
    private static final By passwordInput = By.xpath(".//*[@id='field_password']");
    private static final By loginButton = By.xpath(".//input[@class='button-pro __wide']");
    private static final By loginErrorText = By.xpath("//div[@class='input-e login_error']");
    private static final By buttonAuth = By.xpath(".//*[@id='login_tab']");
    private static final By formAuth = By.xpath("//div[@class='tab-body']");


    public LoginPage() {
        checkLoginPage();
    }
    public LoginPage open() {
        Selenide.open("/");
        return this;
    }

    private void checkLoginPage() {
        $(loginInput).shouldBe(visible);
        $(passwordInput).shouldBe(visible);
        $(loginButton).shouldBe(visible);
    }

    public void signIn(String login, String password) {
        $(loginInput).shouldBe(visible).setValue(login);
        $(passwordInput).shouldBe(visible).setValue(password).pressEnter();
    }

    public void checkIncorrectLogin() {
        $(loginErrorText).shouldBe(visible).shouldHave(text("Неправильно указан логин и/или пароль"));
    }

    public boolean pageAuth() {
        return $(buttonAuth).shouldBe(visible).isDisplayed();
    }

    public boolean pageAuth2() {
        return $(formAuth).shouldBe(visible).isDisplayed();
    }

    public NewPage login() {
        $(loginButton).shouldBe(visible).click();
        return new NewPage();

    }



}