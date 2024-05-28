package luma.shoptests;

import com.luma.Base;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseTests extends Base {
    @Test()
    public void addProductAndCompletePurchase(String firstName, String lastName, String company, String address, String city, String state, String countryId, String zipCode, String phone) throws InterruptedException {
        mainPage.goToYogaShop();
        yogaShopPage.goToProductItemPage();
        productPage.addProductToCart("2");
        try{
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String alertText = alert.getText();
            Assert.assertTrue(alertText.contains("added to your shopping cart"),"Added to shopping cart");
            System.out.println("Alert Text: " + alertText);
        } catch (Exception e){}
        checkoutPage.fillInShippingFormNewCustomer(firstName, lastName, company, address, city, state, countryId, zipCode, phone);
        productPage.goToCheckout();
        checkoutPage.selectPaymentMethod();
    }}
