package Pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    protected static final By miniUserToolbar = By.xpath("//button[@aria-label='Настройки профиля']");
    protected static final By userButton = byXpath("//*[@data-l='t,userPage']");
    protected static final By exitButton = By.xpath("//div[@class='toolbar_accounts-user-delete-button']");
    protected static final By confirmationOfExitButton = By.xpath("//*[@id='hook_FormButton_logoff.confirm_not_decorate']");

    public static void logOut() {
        $(miniUserToolbar).shouldBe(visible.because("Mini toolbar should be on every page")).click();
        $(exitButton).shouldBe(visible.because("Exit button should be on every page")).click();
        $(confirmationOfExitButton).shouldBe(enabled.because("Confirmation of exit button should be enabled to exit")).click();
    }


}