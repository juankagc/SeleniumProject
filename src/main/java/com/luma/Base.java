package com.luma;

import com.pageobjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

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
    protected LoginPage loginPage;


    @BeforeMethod
    public void setUpDriver() {
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver.get(new MainPage(driver).getUrl());
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(100));
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        signUpFormPage = new SignUpFormPage(driver);
        accountPage = new AccountPage(driver);
        yogaShopPage = new YogaShopPage(driver);
        productPage = new ProductPage(driver);
        checkoutPage = new CheckoutPage(driver);
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDownDriver() {
        driver.quit();
    }
}
