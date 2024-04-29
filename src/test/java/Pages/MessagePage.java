package Pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MessagePage extends BasePage {
    private static final By SEARCH_FRIENDS = By.xpath("//*[@data-l='t,chatsSearchInput']");
    private static final By MESSAGE_PAGE = By.xpath("//*[@id='hook_Block_MessagesLayer']");
    private static final By PROFILE_FRIEND = By.xpath("//*[contains(@data-tsid-id,'DIALOG')]");
    private static final By OPEN_INPUT_MESSAGE = By.xpath("//*[contains(@data-tsid,'write_msg_input-input')]");
    private static final By SEND_MESSAGE = By.xpath("//*[contains(@class,'primary-okmsg')]");


    public MessagePage() {
        checkOpenMessenger();
    }

    public static boolean checkOpenMessenger() {
        $(MESSAGE_PAGE).shouldBe(visible.because("MESSAGE PAGE should be visible on MESSAGE PAGE"));
        $(SEARCH_FRIENDS).shouldBe(visible.because("SEARCH FRIENDS should be visible to click")).click();
        return true;
    }

    public static void searchFriends(String friendName) {
        $(SEARCH_FRIENDS).shouldBe(visible.because("SEARCH FRIENDS form should be visible on message page to send")).sendKeys(friendName);
    }

    public static void sendMessageFriend(String text) {
        $(PROFILE_FRIEND).shouldBe(visible.because("PROFILE FRIEND should be visible to click on message page")).click();
        $(OPEN_INPUT_MESSAGE).shouldBe(visible.because("OPEN INPUT MESSAGE should be visible to click on message page")).click();
        $(OPEN_INPUT_MESSAGE).shouldBe(visible.because("OPEN INPUT MESSAGE should be visible to click on message page")).sendKeys(text);
        $(SEND_MESSAGE).click();
    }


}

