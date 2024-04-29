package Tests;

import Pages.MessagePage;
import Pages.UserMainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static Pages.BasePage.logOut;

public class OpenMessengerTest extends BaseTest {
    private UserMainPage userMainPage;

    @BeforeEach
    public void setup() {
        authorize();
    }

    @Test
    @Tag("Search friend in messenger")
    public void clickOpenMessenger() {
        UserMainPage.openMessenger();
        MessagePage.searchFriends("technopol42");
        Assertions.assertTrue(MessagePage.checkOpenMessenger(), "Мессенджер открывается");
        logOut();
    }

    @Test
    @Tag("Messenger")
    public void sendMessageFriend() {
        UserMainPage.openMessenger();
        MessagePage.searchFriends("technopol42");
        MessagePage.sendMessageFriend("Привет");
        logOut();
    }


}
