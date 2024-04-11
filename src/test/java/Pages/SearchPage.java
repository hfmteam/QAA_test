package Pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage extends BasePage {

    private By friendProfileButton = byXpath("//a[@href='/profile/576417343743']");
    private By upperPeopleButton = byXpath("//button[@id='tab-users']");
    private By upperPublicationsButton = byXpath("//button[@id='tab-publications']");
    private By upperGroupsButton = byXpath("//button[@id='tab-groups']");

    public SearchPage() {
        checkPage();
    }

    private void checkPage() {
        $(upperPeopleButton).shouldBe(visible);
        $(upperPublicationsButton).shouldBe(visible);
        $(upperGroupsButton).shouldBe(visible);
    }

    public FriendPage openFriendPage() {
        $(friendProfileButton).shouldBe(visible.because("Friend profile button should be visible to open")).click();
        return new FriendPage();
    }
}
