package Tests;

import Pages.MainPage;
import Pages.NewPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class PlayVideoTest extends BaseTest {
    private MainPage mainPage;
    private NewPage newPage;

    @BeforeEach
    public void setup() {
        NewPage newsPage = authorize();
        mainPage = newsPage.openUserPage();
    }

    @Test
    @Tag("Video")
    public void playVideoTest() throws InterruptedException {
        mainPage.setPlayVideo();
        TimeUnit.SECONDS.sleep(5);
        Assertions.assertTrue(mainPage.checkOpenVideo(), "Музыка играет");
    }
}