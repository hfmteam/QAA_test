package Pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class NewPage extends BasePage {

    private static final By momentsButton = byXpath("//button[@data-l='t,to_moments']");
    private static final By hobbyButton = byXpath("//button[@data-l='t,to_hobbies']");
    private static final By avatar = byXpath("//div[@class='card_wrp']");

    public NewPage() {
        checkPage();
    }

    private void checkPage() {
        $(momentsButton).shouldBe(visible);
        $(hobbyButton).shouldBe(visible);
        $(avatar).shouldBe(visible);
    }

    public MainPage openUserPage() {
        $(userButton).shouldBe(visible.because("User button should be visible to click")).click();
        return new MainPage();
    }

    public boolean checkMoment() {

        return ($(byText("Моменты")).exists());
    }
}