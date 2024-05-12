package tests;

import Pages.LoginPage;
import Pages.MusicPage;
import Pages.UserMainPage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName(" Test")

public class MusicPageTest extends BaseTest {

    String s = "Песня добавлена. Вам также может понравиться";
    private UserMainPage userMainPage;

    @BeforeEach
    public void setup() {
        LoginPage loginPage = new LoginPage(driver).get();
        userMainPage = loginPage.login();

    }

    @AfterEach
    public void logoutUser() {
        userMainPage.logout();
    }

    @Test
    @Tag("Play_music")
    public void playMusic() throws InterruptedException {
        UserMainPage.openMusic();
        MusicPage.setPlayMusic();
        Assertions.assertTrue(UserMainPage.openMusic(), "Музыка играет");
    }

    @Test
    @Tag("Add_music_favourite")
    public void addMusic() throws InterruptedException {
        UserMainPage.openMusic();
        MusicPage.addFavouriteMusic();
        String textFavourite = MusicPage.checkAddFavouriteMusic();
        Assertions.assertEquals("Песня добавлена. Вам также может понравиться", textFavourite);
    }

    @Test
    @Tag("Off_Volume_Music")
    public void offVolume() throws InterruptedException {
        UserMainPage.openMusic();
        MusicPage.setPlayMusic();
        MusicPage.offVolumeMusic();
        assertTrue(MusicPage.checkoffVolumeMusic());
    }

}