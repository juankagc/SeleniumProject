package com.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AccountPage extends MainPage {

    @FindBy(xpath = "//*[contains(text(), 'Thank you')]")
    private WebElement successfulRegisterMessage;

    public AccountPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @Step("Verify Account is created")
    public void verifyAccountCreated(){
        wait.until(ExpectedConditions.visibilityOf(successfulRegisterMessage));
        Assert.assertTrue(successfulRegisterMessage.isDisplayed());
    }
}
