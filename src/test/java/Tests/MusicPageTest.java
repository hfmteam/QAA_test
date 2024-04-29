package Tests;

import Pages.MusicPage;
import Pages.UserMainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static Pages.BasePage.logOut;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MusicPageTest extends BaseTest {

    String s = "Песня добавлена. Вам также может понравиться";
    private UserMainPage userMainPage;

    @BeforeEach
    public void setup() {
        authorize();
    }

    @Test
    @Tag("Play_music")
    public void playMusic() throws InterruptedException {
        UserMainPage.openMusic();
        MusicPage.setPlayMusic();
        Assertions.assertTrue(UserMainPage.openMusic(), "Музыка играет");
        logOut();
    }

    @Test
    @Tag("Add_music_favourite")
    public void addMusic() throws InterruptedException {
        UserMainPage.openMusic();
        MusicPage.addFavouriteMusic();
        String textFavourite = MusicPage.checkAddFavouriteMusic();
        Assertions.assertEquals("Песня добавлена. Вам также может понравиться", textFavourite);
        logOut();
    }

    @Test
    @Tag("Off_Volume_Music")
    public void offVolume() throws InterruptedException {
        UserMainPage.openMusic();
        MusicPage.setPlayMusic();
        MusicPage.offVolumeMusic();
        assertTrue(MusicPage.checkoffVolumeMusic());
        logOut();
    }

}