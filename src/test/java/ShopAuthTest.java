import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Header;
import pages.ShopLoginPage;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopAuthTest {
    //testtest777@gmail.com
    ChromeDriver driver;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-4/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/login");
    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void successAuth() throws InterruptedException {
        String email = "testtest777@gmail.com";
        ShopLoginPage shopLoginPage = new ShopLoginPage(driver);
        shopLoginPage.enterEmail(email);
        //enter password
        shopLoginPage.enterPassword("Qq12345");
        //click on Log in button
        shopLoginPage.clickOnLoginButton();
        //check that log in is successful
        Header header = new Header(driver);
        assertEquals(email, header.getAccountEmail());
    }

    @Test
    public void invalidPassword(){
        String email = "testtest777@gmail.com";
        ShopLoginPage shopLoginPage = new ShopLoginPage(driver);
        shopLoginPage.enterEmail(email);
        //enter password
        shopLoginPage.enterPassword("fwsefsdfser");
        //click on Log in button
        shopLoginPage.clickOnLoginButton();
        assertEquals("Login was unsuccessful. Please correct the errors and try again.",
                shopLoginPage.getErrorMessageText());
    }
}
