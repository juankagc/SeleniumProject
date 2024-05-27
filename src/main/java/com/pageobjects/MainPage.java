package com.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    @FindBy(xpath ="//*[@class='logo']")
    private WebElement pageLogo;
    @FindBy(xpath ="//div[@class='panel header']//a[normalize-space()='Create an Account']")
    private WebElement signInButton;
    @FindBy(xpath ="//div[@class='panel header']//a[normalize-space()='Create an Account']")
    private WebElement registerButton;
    @FindBy(xpath = "//span[@class='action more button']")
    private WebElement shopYogaButton;
    protected static WebDriver driver;
    protected static WebDriverWait wait;


    public final String url = "https://magento.softwaretestingboard.com/";

    public MainPage(WebDriver webDriver) {
        PageFactory.initElements(driver,this);
        driver = webDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(100));
    }
    public String getUrl(){
        return url;
    }

    @Step("Verify the Page loads successfully")
    public void verifyPageLogo(){
        wait.until(ExpectedConditions.visibilityOf(pageLogo));
    }
    @Step("Click on Register button")
    public void clickOnRegisterButton(){
        wait.until(ExpectedConditions.visibilityOf(registerButton));
        registerButton.click();
    }
    @Step("Click on Sign In button")
    public void clickOnSignInButton(){
        wait.until(ExpectedConditions.visibilityOf(signInButton));
        signInButton.click();
    }
    @Step("Go to Main Menu")
    public void goToMainMenu(){
        wait.until(ExpectedConditions.visibilityOf(pageLogo));
        pageLogo.click();
    }
    @Step("Go to Yoga Shop")
    public void goToYogaShop(){
        wait.until(ExpectedConditions.visibilityOf(shopYogaButton));
        shopYogaButton.click();
    }
}
