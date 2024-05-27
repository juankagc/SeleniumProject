package com.pageobjects;

import com.pageobjects.MainPage;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class ProductPage extends MainPage {

    @FindBy(xpath = "//div[@class='swatch-attribute size']//div[@class='swatch-option text']")
    private List<WebElement> productSize;
    @FindBy(xpath ="//div[@class='swatch-attribute color']//div[@class='swatch-option color']")
    private List<WebElement> productColor;
    @FindBy(id = "qty")
    private WebElement inputQtyField;
    @FindBy(xpath = "//button[@type='submit' and @title='Add to Cart']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//div[@class='minicart-wrapper']")
    private WebElement minicartWrapper;
    @FindBy(id = "top-cart-btn-checkout")
    private WebElement checkoutButton;
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Step("Add product to Cart")
    public void addProductToCart(String quantity){
        wait.until(ExpectedConditions.visibilityOfAllElements(productSize));
        wait.until(ExpectedConditions.visibilityOfAllElements(productColor));
        productSize.get(0).click();
        productColor.get(0).click();
        inputQtyField.clear();
        inputQtyField.sendKeys(quantity);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
        try{
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String alertText = alert.getText();
            Assert.assertTrue(alertText.contains("added to your shopping cart"),"Added to shopping cart");
            System.out.println("Alert Text: " + alertText);
        } catch (Exception e){}
    }
    @Step("Go to Checkout")
    public void goToCheckout(){
        wait.until(ExpectedConditions.visibilityOf(minicartWrapper));
        minicartWrapper.click();
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        checkoutButton.click();
    }

}
