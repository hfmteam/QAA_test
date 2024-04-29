package Tests;

import Pages.UserMainPage;
import Pages.VideoPage;
import Pages.VideoPlayerPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static Pages.BasePage.logOut;

public class PlayVideoTest extends BaseTest {
    @BeforeEach
    public void setup() {
        authorize();
    }

    @Test
    @Tag("Play_Video")
    public void playVideoTest() {
        UserMainPage.openVideoPage();
        VideoPage.checkVideoPage();
        VideoPage.openVideoPlayer();
        VideoPlayerPage.checkVideoPlayerPage();
        VideoPlayerPage.checkOpenVideo();
        Assertions.assertTrue(VideoPlayerPage.checkOpenVideo(), "Видео воспроизводится");
        VideoPlayerPage.pauseVideo();
        VideoPlayerPage.closeVideoPlayer();
        logOut();
    }

    @Test
    @Tag("Like_it")
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
        logOut();
    }

}
