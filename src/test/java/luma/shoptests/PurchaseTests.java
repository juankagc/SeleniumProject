package luma.shoptests;

import com.luma.Base;
import org.testng.annotations.Test;

public class PurchaseTests extends Base {
    @Test
    public void addProductAndCompletePurchase() throws InterruptedException {
        mainPage.goToYogaShop();
        yogaShopPage.goToProductItemPage();
        productPage.addProductToCart("2");
        productPage.goToCheckout();
        checkoutPage.fillCheckoutShippingFormNewCustomer("Juan","Gimenez","Oktana","Fake Street 1234","New York","Alabama","US","94404","123456789");
        Thread.sleep(5000);
        checkoutPage.selectPaymentMethod();
    }
}