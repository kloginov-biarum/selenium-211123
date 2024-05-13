package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopRegistrationPage {

    //Page Object Model patter

    WebDriver driver;

    public ShopRegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "gender-male")
    private WebElement genderMale;

    @FindBy(id = "gender-female")
    private WebElement genderFemale;

    @FindBy(id = "FirstName")
    private WebElement firstNameInputField;
    //    enterValueToLastName
    @FindBy(id = "LastName")
    private WebElement lastNameInputField;

    @FindBy(id = "Email")
    private WebElement emailInputField;
    @FindBy(id = "Password")
    private WebElement passwordInputField;

    //ConfirmPassword
    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordInputField;

    @FindBy(id = "register-button")
    private WebElement registerButton;

    public void chooseGenderMale(){
        genderMale.click();
    }

    public void chooseGenderFemale(){
        genderFemale.click();
    }

    public void enterValueToFirstName(String firstNameValue){
        firstNameInputField.sendKeys(firstNameValue);
    }
    public void enterValueToLastName(String lastNameValue){
        lastNameInputField.sendKeys(lastNameValue);
    }
    //enterValueToEmail
    public void enterValueToEmail(String emailValue){
        emailInputField.sendKeys(emailValue);
    }

    //enterValueToPassword
    public void enterValueToPassword(String passwordValue){
        passwordInputField.sendKeys(passwordValue);
    }
    //confirmPasswordInputField
    public void enterValueToConfirmPassword(String confirmPasswordValue){
        confirmPasswordInputField.sendKeys(confirmPasswordValue);
    }

    public void clickOnRegisterButton(){
        registerButton.click();
    }


}
