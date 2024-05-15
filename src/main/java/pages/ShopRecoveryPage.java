package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopRecoveryPage {

    WebDriver driver;

    public ShopRecoveryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    private WebElement emailInputField;

    @FindBy(css = "[value=\"Recover\"]")
    private WebElement recoverButton;

    @FindBy(className = "result")
    private WebElement resultMessage;


    public void enterEmail(String emailValue){
        emailInputField.sendKeys(emailValue);
    }

    public String getResultMessage(){
        return resultMessage.getText();
    }

    public void clickInRecoverButton(){
        recoverButton.click();
    }
}
