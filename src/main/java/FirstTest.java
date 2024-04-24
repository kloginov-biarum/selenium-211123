
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {

    @Test
    public void firstTest(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-4/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }
}
