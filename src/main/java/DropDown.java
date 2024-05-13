import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class DropDown {
    ChromeDriver driver;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-4/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://suninjuly.github.io/selects1.html");
    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void dropdownTest() throws InterruptedException {
        //Вычислить значение суммы и вывести в терминал
        WebElement num1 = driver.findElement(By.id("num1"));
        WebElement num2 = driver.findElement(By.id("num2"));

        int num1Value = Integer.parseInt(num1.getText());
        int num2Value = Integer.parseInt(num2.getText());

        int sum = num1Value + num2Value;

        System.out.println("Result: " + sum);
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        dropdown.click();

        WebElement answer = driver.findElement(By.cssSelector("[value='" + sum + "']"));
        answer.click();
       // sleep(3000);
        //Click on Submit button
        sleep(3000);
        //Assert that Alert is displayed
    }

}
