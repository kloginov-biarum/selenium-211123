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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Alerts {

    ChromeDriver driver;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-4/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void firstAlertText(){
        WebElement firstButton = driver.findElement(By.id("alertButton"));
        firstButton.click();
        //Check that alert has text "You clicked a button"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
       assertEquals("You clicked a button", alert.getText());
    }
    @Test
    public void secondAlertText(){
        WebElement secondButton = driver.findElement(By.id("timerAlertButton"));
        secondButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("This alert appeared after 5 seconds", alert.getText());
    }
}
