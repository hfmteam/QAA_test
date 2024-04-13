package Pages;

import org.openqa.selenium.By;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class MainPage extends BasePage {
    private static final By navigationToolBar = By.xpath("//div[@class='topPanel']");
    private static final By navigationToolBarButtons = By.xpath("//*[contains(@class,'toolbar_nav_a')]");
    private static final By navigationButtons = By.xpath("//*[contains(@class,'nav-side_i-w')]");
    private static final By navigationBar = By.xpath("//div[@class='nav-side __navigation __user-main']");
    private static final By openMessengerButton = By.xpath("//*[@id='msg_toolbar_button']");
    private static final By searchFriends = By.xpath("//*[@data-l='t,chatsSearchInput']");
    private static final By openMusic = By.xpath("//div[@class='toolbar_music-container']");
    private static final By playMusic = By.xpath("//*[contains(@class,'play __active')]");
    private static final By openVideo = By.xpath("//*[@id='hook_Block_TopMenuVideo']");
    private static final By playVideo = By.xpath("//div[@class='h-mod video-card_preview']");
    private static final By shareButton = By.xpath("//*[@data-l='outlandertarget,share,t,share']");
    private static final By checkNameVideo = By.xpath("//*[contains(@class,'vp-layer-info_h textWrap')]");


    public MainPage() {

        checkMainPage();
    }

    public void checkMainPage() {
        $(navigationToolBar).shouldBe(visible);
        $(navigationBar).shouldBe(visible);
    }

    public void clickMessenger() {
        $(openMessengerButton).shouldBe(visible).click();
        $(searchFriends).shouldBe(visible).click();
    }

    public boolean checkOpenMessenger() {
        $(searchFriends).shouldBe(visible).click();
        return true;
    }

    public void setPlayMusic() {
        $(openMusic).shouldBe(visible).click();
        $(playMusic).shouldBe(visible).click();
    }

    public boolean checkOpenMusic() {
        $(openMusic).shouldBe(visible).click();
        return true;
    }

    public void setPlayVideo() {
        $(openVideo).shouldBe(visible).click();
        $(playVideo).shouldBe(hidden).click();
    }

    public boolean checkOpenVideo() {
        $(checkNameVideo).shouldBe(visible).click();
        return true;
    }

    public String copyUrl() throws IOException, UnsupportedFlavorException, InterruptedException {
        $(shareButton).shouldBe(interactable.because("Share button should be interactable to share")).click();
        $(byText("Копировать ссылку")).shouldBe(visible.because("Copy button should be visible to use")).click();
        return (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
    }

    public void setText(String friendName) {
        $(searchFriends).shouldBe(visible).sendKeys(friendName);

    }

}



