import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Registration {

    ChromeDriver driver;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-4/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://suninjuly.github.io/registration1.html");
    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void successRegistrationWithRequiredFields() throws InterruptedException {
        WebElement firstNameInputField = driver.findElement(By.cssSelector("[placeholder=\"Input your first name\"]"));
        firstNameInputField.sendKeys("John");
        WebElement lastNameInputFiled = driver.findElement(By.cssSelector("[placeholder=\"Input your last name\"]"));
        lastNameInputFiled.sendKeys("Black");
        WebElement emailInputFiled = driver.findElement(By.cssSelector("[placeholder=\"Input your email\"]"));
        emailInputFiled.sendKeys("jblack@gmail.com");
        WebElement submitButton = driver.findElement(By.cssSelector("[type=\"submit\"]"));
        submitButton.click();
        //Assert that we can see text "You have successfully registered!"
        WebElement header = driver.findElement(By.tagName("h1"));
        //assertEquals("Congratulations! You have successfully registered!", header.getText());
        assertTrue(header.getText().contains("You have successfully registered!"));
    }


    //Check all input fields
    public void successRegistartionWithAllFields(){

    }

    @Test
    public void withoutFirstName(){
        WebElement lastNameInputFiled = driver.findElement(By.cssSelector("[placeholder=\"Input your last name\"]"));
        lastNameInputFiled.sendKeys("Black");
        WebElement emailInputFiled = driver.findElement(By.cssSelector("[placeholder=\"Input your email\"]"));
        emailInputFiled.sendKeys("jblack@gmail.com");
        WebElement submitButton = driver.findElement(By.cssSelector("[type=\"submit\"]"));
        submitButton.click();
        WebElement firstNameInputField = driver.findElement(By.cssSelector("[placeholder=\"Input your first name\"]"));
        assertEquals("Заполните это поле.", firstNameInputField.getAttribute("validationMessage"));
    }

    //1. without Last name


    //2. without email

    //3. without all requirment fields
}
