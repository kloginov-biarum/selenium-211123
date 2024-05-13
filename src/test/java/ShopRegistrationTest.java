import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ShopRegisterResultPage;
import pages.ShopRegistrationPage;

import java.util.Random;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopRegistrationTest {

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
    public void successRegistrAllValidFields() throws InterruptedException {
        Faker faker = new Faker();
        String randomEmail = faker.internet().emailAddress();
        //Choose gender
        ShopRegistrationPage shopRegistrationPage = new ShopRegistrationPage(driver);
        shopRegistrationPage.chooseGenderFemale();
        //Enter first name
        shopRegistrationPage.enterValueToFirstName("John");
        //Last name
        shopRegistrationPage.enterValueToLastName("Pi");
        //Email
        shopRegistrationPage.enterValueToEmail(randomEmail);
        //Password
        shopRegistrationPage.enterValueToPassword("123456");
        //Confirm password
        shopRegistrationPage.enterValueToConfirmPassword("123456");
        //Click on Register button
        shopRegistrationPage.clickOnRegisterButton();
        sleep(5000);
        //Check that text "Your registration completed" is displayed
        ShopRegisterResultPage resultPage = new ShopRegisterResultPage(driver);
        assertEquals("Your registration completed", resultPage.getResultText());
    }


    protected String getSaltString() {
            String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
            StringBuilder salt = new StringBuilder();
            Random rnd = new Random();
            while (salt.length() < 10) { // length of the random string.
                int index = (int) (rnd.nextFloat() * SALTCHARS.length());
                salt.append(SALTCHARS.charAt(index));
            }
            String saltStr = salt.toString();
            return saltStr.toLowerCase() + "@gmail.com";
        }

    @Test
    public void emailGenerateTest(){
        System.out.println(getSaltString());
    }
    @Test
    public void invalidDataEmptyFirstNameTest(){
        //
        //check that "First name is required." error message text is displayed
    }


    //1. Specify all fields with valid data, Last name is empty, check the error message text
    //2. Specify all fields with valid data,Email is empty, check the error message text
    //3 .Specify all fields with valid data, Email invalid format (without @), check the error message text


}
