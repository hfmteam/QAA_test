package Pages;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    private final SelenideElement navigationToolBar = $(By.xpath("//div[@data-l='t,navigationToolbar']"));
    private final ElementsCollection navigationToolBarButtons = $$(By.xpath("//*[contains(@class,'toolbar_nav_a')]"));
    private final ElementsCollection navigationButtons = $$(By.xpath("//div[@class='nav-side_i-w']"));
    private final SelenideElement navigationBar = $(By.xpath("//div[@class='nav-side __navigation __user-main']"));
    private final SelenideElement openMessengerButton = $(By.xpath("//*[@id='msg_toolbar_button']"));
    private final SelenideElement searchFriends = $(By.xpath("//div[@class='item_bottom-okmsg']"));
    private final SelenideElement openMusic = $(By.xpath("//div[@class='toolbar_music-container']"));
    private final SelenideElement playMusic = $(By.xpath("//*[@id='music_layer']/header/wm-player/wm-player-controls/button[3]"));
    private final SelenideElement openVideo = $(By.xpath("//*[@id='hook_Block_TopMenuVideo']"));
    private final SelenideElement playVideo = $(By.xpath("//div[@class='h-mod video-card_preview']"));

    public MainPage openLoggedIn() {
        LoginPage loginPage = new LoginPage();
        Selenide.open("/");
        loginPage.signIn("technopol32", "technopolisPassword");
        return this;
    }

    public void checkMainPage() {
        navigationToolBar.shouldBe();
        navigationBar.shouldBe();
        Assertions.assertEquals(8, navigationToolBarButtons.size());
        Assertions.assertEquals(11, navigationButtons.size());
    }

    public void clickMessenger() {
        openMessengerButton.click();
        searchFriends.click();
    }

    public void setPlayMusic() {
        openMusic.click();
        playMusic.click();
    }

    public void setPlayVideo() {
        openVideo.click();
        playVideo.click();

    }
}



