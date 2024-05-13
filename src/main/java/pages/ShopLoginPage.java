package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopLoginPage {

    WebDriver driver;

    public ShopLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //Web Elements:
    //email input filed
    @FindBy(id = "Email")
    private WebElement emailInputField;
    //password input field

    @FindBy(id = "Password")
    private WebElement passwordInputField;

    //Log in button

    @FindBy(css = "[value=\"Log in\"]")
    private WebElement loginButton;

    @FindBy(css = ".validation-summary-errors>span")
    private WebElement errorMessage;

    //input value to email input field
    public void enterEmail(String emailValue){
        emailInputField.sendKeys(emailValue);
    }

    //input value to password input field
    public void enterPassword(String passwordValue){
        passwordInputField.sendKeys(passwordValue);
    }

    //click on the Log in button
    public void clickOnLoginButton(){
        loginButton.click();
    }


    public String getErrorMessageText(){
        return errorMessage.getText();
    }

}
