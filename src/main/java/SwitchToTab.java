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
import java.util.ArrayList;

import static java.lang.Math.*;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SwitchToTab {

    ChromeDriver driver;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-4/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://suninjuly.github.io/redirect_accept.html");
    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    public double funcCalc(double x){
        return log(abs(12*sin(x)));
    }
    @Test
    public void switchToTabTest() throws InterruptedException {

        WebElement redirectButton = driver.findElement(By.tagName("button"));
        sleep(1000);
        redirectButton.click();
       // sleep(5000);
        System.out.println(driver.getWindowHandles());//return all opened tabs ids
        System.out.println(driver.getWindowHandle());//return active tab
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        WebElement x = driver.findElement(By.id("input_value"));
        double result = funcCalc(Double.parseDouble(x.getText()));
        WebElement answerInputField = driver.findElement(By.id("answer"));
        answerInputField.sendKeys(String.valueOf(result));
        //Click Submit button
        WebElement submitButton = driver.findElement(By.tagName("button"));
        submitButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));
    }
}
