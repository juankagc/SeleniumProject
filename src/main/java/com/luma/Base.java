package com.luma;

import com.pageobjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class Base {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected MainPage mainPage;
    protected SignUpFormPage signUpFormPage;
    protected AccountPage accountPage;
    protected YogaShopPage yogaShopPage;
    protected ProductPage productPage;
    protected CheckoutPage checkoutPage;


    @BeforeClass
    public void setUpDriver(){
        driver = new ChromeDriver();
        driver.get(new MainPage(driver).getUrl());
        wait = new WebDriverWait(driver, Duration.ofSeconds(10),Duration.ofMillis(100));
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        signUpFormPage = new SignUpFormPage(driver);
        accountPage = new AccountPage(driver);
        yogaShopPage = new YogaShopPage(driver);
        productPage = new ProductPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }
@BeforeClass
    public void tearDownDriver(){
        driver.quit();
    }
}
