import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Header;
import pages.ShopLoginPage;
import pages.ShopRecoveryPage;

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

    //Enter invalid email format
    //Check that error message text "Please enter a valid email address." is displayed
    @Test
    public void invalidFormatEmail() {
        String email = "testtest777gmail.com"; //   некорректный email
        ShopLoginPage loginPage = new ShopLoginPage(driver);
        loginPage.enterEmail(email);
        loginPage.clickOnPasswordInputFiled();
        assertEquals("Please enter a valid email address.",loginPage.getEmailValErrorMessageText());
    }


    //Unexisting email vfdvhfvh@gmail.com

    //Empty email


    //Follow the Forgot password? link
    //Check that user is on the recovery password page
    @Test
    public void forgotPasswordLinkTest(){
    }

    //Enter valid email
    //click on Recover button
    //Check that "Email with instructions has been sent to you." is displayed
    @Test
    public void validRecovery(){
        ShopLoginPage loginPage = new ShopLoginPage(driver);
        loginPage.followForgotPassLink();
        ShopRecoveryPage recoveryPage = new ShopRecoveryPage(driver);
        recoveryPage.enterEmail("testtest777@gmail.com");
        recoveryPage.clickInRecoverButton();
        assertEquals("Email with instructions has been sent to you.", recoveryPage.getResultMessage());
    }
}
