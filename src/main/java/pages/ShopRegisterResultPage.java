package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopRegisterResultPage {

    WebDriver driver;

    public ShopRegisterResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".page-body>.result")
    private WebElement resultText;

    public String getResultText(){
        return resultText.getText();
    }
}
