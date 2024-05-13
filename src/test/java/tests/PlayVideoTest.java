package tests;

import Pages.LoginPage;
import Pages.UserMainPage;
import Pages.VideoPage;
import Pages.VideoPlayerPage;
import org.junit.jupiter.api.*;


public class PlayVideoTest extends BaseTest {
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
    @Tag("Video")
    @DisplayName("Play Video test")
    public void playVideoTest() {
        UserMainPage.openVideoPage();
        VideoPage.checkVideoPage();
        VideoPage.openVideoPlayer();
        VideoPlayerPage.checkVideoPlayerPage();
        VideoPlayerPage.checkOpenVideo();
        Assertions.assertTrue(VideoPlayerPage.checkOpenVideo(), "Видео воспроизводится");
        VideoPlayerPage.pauseVideo();
        VideoPlayerPage.closeVideoPlayer();

    }

    @Test
    @Tag("Video")
    @DisplayName("Play Video & Like it test")
    public void setClassVideo() {
        UserMainPage.openVideoPage();
        VideoPage.checkVideoPage();
        VideoPage.openVideoPlayer();
        VideoPlayerPage.checkVideoPlayerPage();
        VideoPlayerPage.checkOpenVideo();
        Assertions.assertTrue(VideoPlayerPage.checkOpenVideo(), "Видео воспроизводится");
        VideoPlayerPage.pauseVideo();
        VideoPlayerPage.likeVideo();
        Assertions.assertTrue(VideoPlayerPage.checkLikeVideo(), "Лайк прожат");
        VideoPlayerPage.closeVideoPlayer();

    }

}
