import com.github.javafaker.Faker;
import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

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
        Faker faker = new Faker();
        String randomEmail = faker.internet().emailAddress();


        //Input all data


        //Text "Your registration completed" is displayed
        WebElement emailInputField = driver.findElement(By.id(""));
        emailInputField.sendKeys(randomEmail);
        //Button "Continue" is displayed
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
