package Tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import Pages.NewPage;
import Pages.LoginPage;
import Pages.MainPage;

import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;


public class BaseTest {
    static final Logger log = getLogger(lookup().lookupClass());
    private static final String login = "technopol32";
    private static final String password = "technopolisPassword";


    @BeforeAll
    public static void setUp() {
        log.info("Start Window");
        Configuration.baseUrl = "https://ok.ru/";
        Configuration.browserSize = "1920x1080";
        Selenide.open("/");
    }
    public static NewPage authorize() {
        LoginPage loginPage = new LoginPage();
        loginPage.signIn(login, password);
        return loginPage.login();
    }


}
