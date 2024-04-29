package Pages;

import org.openqa.selenium.By;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class UserMainPage extends BasePage {
    private static final By NAVIGATION_TOOLBAR = By.xpath("//div[@class='topPanel']");
    private static final By NAVIGATION_BAR = By.xpath("//*[@id='hook_Block_SideNavigation']");
    private static final By OPEN_MESSENGER_BUTTON = By.xpath("//*[@id='msg_toolbar_button']");
    private static final By OPEN_MUSIC = By.xpath("//div[@class='toolbar_music-container']");
    private static final By SHARE_BUTTON = By.xpath("//*[@class='u-menu_a button-clear']");
    private static final By MOMENTS_BUTTON = byXpath("//button[@data-l='t,to_moments']");
    private static final By HOBBY_BUTTON = byXpath("//button[@data-l='t,to_hobbies']");
    private static final By AVATAR = byXpath("//div[@class='card_wrp']");
    private static final By USER_BUTTON = byXpath("//*[@data-l='t,userPage']");
    private static final By OPEN_VIDEO_PAGE = By.xpath("//*[@id='hook_Block_TopMenuVideo']");


    public UserMainPage() {
        checkMainPage();
    }

    public static void openMessenger() {
        $(OPEN_MESSENGER_BUTTON).shouldBe(visible.because("OPEN MESSENGER BUTTON should be visible to click")).click();
    }

    public static boolean openMusic() {
        $(OPEN_MUSIC).shouldBe(visible.because("OPEN MUSIC button should be visible to click")).click();
        return true;
    }

    public static String copyUrl() throws IOException, UnsupportedFlavorException {
        $(SHARE_BUTTON).shouldBe(interactable.because("Share button should be interactable to share")).click();
        $(byText("Копировать ссылку")).shouldBe(visible.because("Copy button should be visible to use")).click();
        return (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
    }

    public static void openUserPage() {
        $(USER_BUTTON).shouldBe(visible.because("User button should be visible to click")).click();
    }

    public static void openVideoPage() {
        $(OPEN_VIDEO_PAGE).shouldBe(visible.because("OPEN VIDEO button should be visible to click")).click();
    }

    public void checkMainPage() {
        $(NAVIGATION_TOOLBAR).shouldBe(visible.because("NavigationToolBar should be visible on user main page"));
        $(NAVIGATION_BAR).shouldBe(visible.because("NavigationBar should be visible on user main page"));
        $(MOMENTS_BUTTON).shouldBe(visible.because("MOMENTS BUTTON should be visible on user main page"));
        $(HOBBY_BUTTON).shouldBe(visible.because("HOBBY BUTTON should be visible on user main page"));
        $(AVATAR).shouldBe(visible.because("AVATAR should be visible on user main page"));
    }

    public boolean checkMoment() {
        return ($(byText("Моменты")).exists());
    }

}





