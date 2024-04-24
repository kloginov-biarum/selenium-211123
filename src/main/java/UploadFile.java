import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UploadFile {

    ChromeDriver driver;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-4/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://suninjuly.github.io/file_input.html");
    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void uploadFileTest() throws InterruptedException {
        //Input First name
        WebElement firstNameInputField =
                driver.findElement(By.xpath("//input[@placeholder='Enter first name']"));
        firstNameInputField.sendKeys("John");
        //Input Last name
        WebElement lastNameInputField = driver.findElement(By.xpath("//input[@placeholder=\"Enter last name\"]"));
        lastNameInputField.sendKeys("Berg");
        //...
        //Input Email
        WebElement emailInputField = driver.findElement(By.xpath("//input[@placeholder=\"Enter email\"]"));
        emailInputField.sendKeys("Berg@gmail.com");
        WebElement uploadFileInput = driver.findElement(By.id("file"));
        uploadFileInput.sendKeys("/Users/ergrevegvrg/Downloads/textfile.txt");
        WebElement submitButton = driver.findElement(By.cssSelector("[type=\"submit\"]"));
        submitButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));
    }

}
