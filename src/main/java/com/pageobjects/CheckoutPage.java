package com.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.luma.utilities.RandomEmail;

import java.util.List;


public class CheckoutPage extends MainPage {
    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement firstNameTextArea;
    @FindBy(name = "lastname")
    private WebElement lastNameTextArea;
    @FindBy(xpath = "//fieldset[@id='customer-email-fieldset']//div/input[@type='email']")
    private WebElement emailTextArea;
    @FindBy(name = "company")
    private WebElement companyTextArea;
    @FindBy(name = "street[0]")
    private WebElement streetTextArea;
    @FindBy(name = "city")
    private WebElement cityTextArea;
    @FindBy(xpath = "//select[@name='region_id']")
    private WebElement stateDropdown;
    @FindBy(xpath = "//select[@name='country_id']")
    private List<WebElement> countryDropdown;
    @FindBy(name = "postcode")
    private WebElement zipCodeTextArea;
    @FindBy(name = "telephone")
    private WebElement phoneTextArea;
    @FindBy(xpath = "//div[@id='checkout-shipping-method-load']/table/tbody/tr")
    private List<WebElement> shippingMethod;
    @FindBy(xpath = "//button[@data-role='opc-continue']")
    private WebElement continueButton;
    @FindBy(xpath = "//div//button[@class='action primary checkout']")
    private WebElement placeOrderButton;
    @FindBy(xpath = "//input[@type='checkbox' and @name= 'billing-address-same-as-shipping']/parent::div")
    private WebElement billingAddressSameAsShippingCheckbox;
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    @Step("Fill In Shipping Address in Checkout Page")
    public void fillCheckoutShippingFormNewCustomer(String firstName, String lastName, String company, String address, String city, String state, String countryId, String zipCode, String phone) {
        /*
        * Waiting for all elements to be present,
        * considering Phone Text Area is the last field
        *  to be filled in the form */
        wait.until(ExpectedConditions.visibilityOf(phoneTextArea));
        /* Fill In checkout form for new customers
        * with no Account created in the store page*/
        String email = RandomEmail.randomEmail();
        emailTextArea.sendKeys(email);
        System.out.println("Email Address: " + email);
        firstNameTextArea.sendKeys(firstName);
        lastNameTextArea.sendKeys(lastName);
        companyTextArea.sendKeys(company);
        streetTextArea.sendKeys(address);
        cityTextArea.sendKeys(city);
        stateDropdown.sendKeys(state);
        countryDropdown.contains(countryId);
        zipCodeTextArea.sendKeys(zipCode);
        phoneTextArea.sendKeys(phone);
        shippingMethod.get(1).click();
        continueButton.click();
    }
    @Step("Select Paym  ent Method")
    public void selectPaymentMethod(){
        wait.until(ExpectedConditions.visibilityOf(placeOrderButton));
        billingAddressSameAsShippingCheckbox.click();
        placeOrderButton.click();
    }

}
