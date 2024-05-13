import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToolTips {
    ChromeDriver driver;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-4/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/tool-tips");
    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void toolTipTest() throws InterruptedException {
        WebElement hoverMeToSeeButton = driver.findElement(By.id("toolTipButton"));
        Actions actions = new Actions(driver);
        sleep(3000);
        actions.moveToElement(hoverMeToSeeButton).perform();
        WebElement tooltip = driver.findElement(By.className("tooltip-inner"));
        //assert
        assertEquals("You hovered over the Button", tooltip.getText());
    }

}
