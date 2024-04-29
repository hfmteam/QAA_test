package Pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class BasePage {
    private static final By USER_TOOLBAR = By.xpath("//button[@aria-label='Настройки профиля']");
    private static final By EXIT_BUTTON = By.xpath("//div[@class='toolbar_accounts-user-delete-button']");
    private static final By CONFIRMATION_OF_EXITBUTTON = By.xpath("//*[@id='hook_FormButton_logoff.confirm_not_decorate']");

    public static void logOut() {
        $(USER_TOOLBAR).shouldBe(visible.because("User toolbar should be on every user page")).click();
        $(EXIT_BUTTON).shouldBe(visible.because("Exit button should be on every user page")).click();
        $(CONFIRMATION_OF_EXITBUTTON).shouldBe(enabled.because("Confirmation of exit button should be enabled to exit")).click();
    }

}