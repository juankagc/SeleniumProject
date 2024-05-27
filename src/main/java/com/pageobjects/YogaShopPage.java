package com.pageobjects;

import com.pageobjects.MainPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class YogaShopPage extends MainPage {

    private Actions actions;

    @FindBy(xpath = "//li[@class='item product product-item']")
    private List<WebElement> productItems;

    public YogaShopPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

    @Step("Add Product to Cart")
    public void goToProductItemPage(){
        wait.until(ExpectedConditions.visibilityOfAllElements(productItems));
        actions.moveToElement(productItems.get(0)).click().perform();
    }
}
