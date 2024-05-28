package com.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends MainPage{
    @FindBy(id = "email")
    private WebElement emailTextField;
    @FindBy(xpath = "//input[@name='login[password]']")
    private WebElement passwordTextField;
    @FindBy(xpath = "//button[@class='action login primary']")
    private WebElement loginButton;
    @FindBy(xpath = "//div[@class='page messages']")
    private WebElement errorMessage;
    public LoginPage(WebDriver driver){ super(driver); }

    @Step("Login with Email and Password")
    public void fillInLoginData(String email, String password){
        wait.until(ExpectedConditions.visibilityOf(emailTextField));
        emailTextField.sendKeys(email);
        passwordTextField.sendKeys(password);
        loginButton.click();
    }
    @Step("Verify Error Message")
    public String verifyErrorMessage(){
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText().toString();
    }
}
