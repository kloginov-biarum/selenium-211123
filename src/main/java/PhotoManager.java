import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhotoManager {
    ChromeDriver driver;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-4/chromedriver");
        driver = new ChromeDriver();
      //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void moveAllElementsToTrash(){
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        WebElement firstPhoto = wait.
                until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[src=\"images/high_tatras_min.jpg\"]")));
               // driver.findElement(By.cssSelector("[src=\"images/high_tatras_min.jpg\"]"));
        WebElement trash = driver.findElement(By.id("trash"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(firstPhoto, trash).perform();

        List<WebElement> recycleButtons = driver.findElements(By.cssSelector("[title=\"Recycle this image\"]")) ;
        assertEquals(4, recycleButtons.size());

    }

}
