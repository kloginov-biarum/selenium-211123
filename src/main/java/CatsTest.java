import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CatsTest {
    ChromeDriver driver;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-4/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://suninjuly.github.io/cats.html");
    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void headerTest(){
        WebElement header = driver.findElement(By.tagName("h1"));
        assertEquals("Cat memes", header.getText());
    }

    @Test
    public void timeOfFirstCatCardTest(){
        WebElement timeFirstCat =
                driver.findElement(By.cssSelector(".col-sm-4:nth-child(1) small"));
        assertEquals("9 mins", timeFirstCat.getText());
    }


    //check that "I love you so much" text contains in name of last cat card

    @Test
    public void lastCatCardNameTest(){
        WebElement lastCardName =
                driver.findElement(By.cssSelector(".col-sm-4:nth-child(6) p"));
        assertEquals("I love you so much", lastCardName.getText());
    }

    @Test
    public void catsAlbumTextTest(){
        WebElement catsAlbum =
                driver.findElement(By.tagName("strong"));
        assertEquals("Cats album", catsAlbum.getText());
    }

    //check that first card is displayed
    @Test
    public void firstCatCardIsDisplayed(){
        WebElement firstCatCard =
                driver.findElement(By.cssSelector(".col-sm-4:nth-child(1)"));
        assertTrue(firstCatCard.isDisplayed());
    }

    //check that photo icon is displayed

    @Test
    public void photoIconIsDisplayed(){
        WebElement photoIcon =
                driver.findElement(By.tagName("svg"));
        assertTrue(photoIcon.isDisplayed());
    }

        @Test
        public  void checkImageQuantity(){

            List<WebElement> images = driver.findElements(By.tagName("img"));
            assertEquals(6, images.size());
        }

        //check that 6 cards with cats are on the page
        @Test
        public  void checkCardsQuantity(){
            List<WebElement> cards = driver.findElements(By.cssSelector(".col-sm-4"));
            assertEquals(6, cards.size());
        }
    @Test
    public  void check9minsQuantity(){
        List<WebElement> minText9 = driver.findElements(By.tagName("small"));
        assertEquals(6, minText9.size());
    }

    //Check that all 6 cards are displayed
    @Test
    public void checkAllCardsAreDisplayed(){
        List<WebElement> cards = driver.findElements(By.cssSelector(".col-sm-4"));
        //each card from cards is displayed
 /*       for (int i=0; i<cards.size();i++){
            assertTrue(cards.get(i).isDisplayed());
        }*/
        for (WebElement card: cards) {
            assertTrue(card.isDisplayed());
        }// - >
       // cards.forEach(card -> assertTrue(card.isDisplayed()));
    }

    //Check that all images are displayed



}
