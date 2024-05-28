package com.pageobjects;

import com.pageobjects.MainPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignUpFormPage extends MainPage {

    @FindBy(id = "firstname")
    private WebElement firstNameTextField;
    @FindBy(id = "lastname")
    private WebElement lastNameTextField;
    @FindBy(id = "email_address")
    private WebElement emailAddressTextField;
    @FindBy(id = "password")
    private WebElement passwordTextField;
    @FindBy(id = "password-confirmation")
    private WebElement passwordConfirmationTextField;
    @FindBy(xpath = "//div/button[@type='submit' and @title='Create an Account']")
    private WebElement createAccountButton;
    @FindBy(xpath = "//*[contains(@id,'-error') and not(contains(@id,'password'))]")
    private WebElement errorMessageMissingFields;
    @FindBy(xpath = "//*[contains(@id,'-error')]")
    private WebElement errorMessagePasswordField;

    public SignUpFormPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @Step("Create a New Account")
    public void createNewAccount(String firstName, String lastName, String email, String password) {
        wait.until(ExpectedConditions.visibilityOf(createAccountButton));
        firstNameTextField.sendKeys(firstName);
        lastNameTextField.sendKeys(lastName);
        emailAddressTextField.sendKeys(email);
        passwordTextField.sendKeys(password);
        passwordConfirmationTextField.sendKeys(password);
        createAccountButton.click();
    }
    public boolean lblGenericErrorMissingFieldsIsDisplayed() {return errorMessageMissingFields.isDisplayed(); }
    public boolean lblErrorPasswordFieldIsDisplayed() {return errorMessagePasswordField.isDisplayed(); }
}
