import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShopRegistration {

    ChromeDriver driver;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-4/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/register");
    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void successRegistrAllValidFields(){
        //Input all data


        //Text "Your registration completed" is displayed
        //Button "Continue" is displayed
    }
}
