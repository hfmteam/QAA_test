package Tests;

import Pages.MainPage;
import Pages.NewPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class PlayMusicTest extends BaseTest {

    private MainPage mainPage;
    private NewPage newPage;

    @BeforeEach
    public void setup() {
        NewPage newsPage = authorize();
        mainPage = newsPage.openUserPage();
    }

    @Test
    @Tag("Music")
    public void playMusic() throws InterruptedException {
        mainPage.setPlayMusic();
        TimeUnit.SECONDS.sleep(3);
        Assertions.assertTrue(mainPage.checkOpenMusic(), "Музыка играет");
    }

}