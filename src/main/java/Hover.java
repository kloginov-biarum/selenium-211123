import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static java.lang.Thread.sleep;

public class Hover {

    ChromeDriver driver;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-4/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://crossbrowsertesting.github.io/hover-menu.html#");
    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void hoverTest() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.cssSelector("a.dropdown-toggle"));
        Actions actions = new Actions(driver);
        actions.moveToElement(dropdown).perform();
        WebElement secondaryMenu = driver.findElement(By.className("secondary-dropdown"));
        actions.moveToElement(secondaryMenu).perform();
        sleep(3000);
        //Click on Secondary action
        WebElement clickSecondary = driver.findElement(By.cssSelector("[onclick=\"handleSecondaryAction()\"]"));
        clickSecondary.click();
        WebElement textSecondary = driver.findElement(By.xpath("(//h1)[2]"));
        textSecondary.getText().contains("Secondary Page");
        //Check that "Secondary Page"

    }



}
