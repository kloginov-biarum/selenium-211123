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
import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HugeForm {
    ChromeDriver driver;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-4/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://suninjuly.github.io/huge_form.html");
    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void specifyHugeFormWithData() throws InterruptedException {
        List<WebElement> inputFields =
                driver.findElements(By.tagName("input"));
        for (WebElement field: inputFields) {
            field.sendKeys("Hello");
        }
        //Click on Submit button
        WebElement submitButton = driver.findElement(By.cssSelector("[type=\"submit\"]"));
        submitButton.click();
       // sleep(30000);
        //"Congrats, you've passed the task!"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));
    }
}
