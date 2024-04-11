package Pages;
import com.codeborne.selenide.WebElementCondition;
import org.junit.jupiter.api.Assertions;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;


import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Condition.enabled;


public class MainPage {
    protected static final By navigationToolBar = By.xpath("//div[@class='topPanel']");
    protected static final By navigationToolBarButtons = By.xpath("//*[contains(@class,'toolbar_nav_a')]");
    protected static final By navigationButtons = By.xpath("//*[contains(@class,'nav-side_i-w')]");
    protected static final By navigationBar = By.xpath("//div[@class='nav-side __navigation __user-main']");
    protected static final By openMessengerButton = By.xpath("//*[@id='msg_toolbar_button']");
    protected static final By searchFriends = By.xpath("//div[@class='item_bottom-okmsg']");
    protected static final By openMusic = By.xpath("//div[@class='toolbar_music-container']");
    protected static final By playMusic = By.xpath("//div[@class='play __active']");
    protected static final By openVideo = By.xpath("//*[@id='hook_Block_TopMenuVideo']");
    protected static final By playVideo = By.xpath("//div[@class='h-mod video-card_preview']");
    protected static final By shareButton = By.xpath("//*[@data-l='outlandertarget,share,t,share']");



    public MainPage openLoggedIn() {
        LoginPage loginPage = new LoginPage();
        open("/");
        return this;
    }

    public void checkMainPage() {
        $(navigationToolBar).shouldBe(visible);
        $(navigationBar).shouldBe(visible);
        $(navigationToolBarButtons).shouldBe(visible).shouldHave(size(8));
        $(navigationButtons).shouldBe(visible).shouldHave(size(11));
    }

    private WebElementCondition size(int i) {
        return null;
    }

    public void clickMessenger() {
        $(openMessengerButton).shouldBe(visible).click();
        $(searchFriends).shouldBe(visible).click();
    }

    public void setPlayMusic() {
        $(openMusic).shouldBe(visible).click();
        $(playMusic).shouldBe(visible).click();
    }

    public void setPlayVideo() {
        $(openVideo).shouldBe(visible).click();
        $(playVideo).shouldBe(visible).click();
    }
    public String copyUrl() throws IOException, UnsupportedFlavorException {
        $(shareButton).shouldBe(interactable.because("Share button should be interactable to share")).click();
        $(byText("Копировать ссылку")).shouldBe(visible.because("Copy button should be visible to use")).click();
        return (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
    }



}



