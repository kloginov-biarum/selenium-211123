import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NestedFrames {
    ChromeDriver driver;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-4/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/nestedframes");
    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void nestedFrames()  {
        driver.switchTo().frame("frame1");
        WebElement parentFrame = driver.findElement(By.tagName("body"));
        assertEquals("Parent frame", parentFrame.getText());
    //Check that "Parent frame" text is displayed

        //Check that "Child Iframe" text is displayed
        WebElement frame2 = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(frame2);
        WebElement childFrame = driver.findElement(By.tagName("p"));
        assertEquals("Child Iframe", childFrame.getText());

    }


}
