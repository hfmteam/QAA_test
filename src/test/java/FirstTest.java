import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FirstTest {

    @Test
    public void firstTest () {
        WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://ok.ru/");
        Assertions.assertEquals("Социальная сеть Одноклассники. Общение с друзьями в ОК. Ваше место встречи с одноклассниками", driver.getTitle());
        if (driver != null)
        driver.close();


    }


}
