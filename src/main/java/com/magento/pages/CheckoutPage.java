package com.magento.pages;


import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {
    @FindBy(css = ".shipping-address-item")
    private ExtendedWebElement shippingAddressSection;

    @FindBy(css = "#shipping-method")
    private ExtendedWebElement shippingMethodSection;

    @FindBy(css = ".payment-method")
    private ExtendedWebElement paymentMethodSection;

    @FindBy(css = "#billing-address-select")
    private ExtendedWebElement billingAddressDropdown;

    @FindBy(css = ".action.checkout")
    private ExtendedWebElement placeOrderButton;

    @FindBy(css = ".checkout-success")
    private ExtendedWebElement orderConfirmationMessage;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void selectShippingAddress(String addressType) {
        shippingAddressSection.click();
        // Additional logic to select specific address
    }

    public void selectShippingMethod(String method) {
        shippingMethodSection.click();
        // Logic to choose shipping method
    }

    public void selectPaymentMethod(String paymentType) {
        paymentMethodSection.click();
        // Logic to select payment method
    }

    public void placeOrder() {
        placeOrderButton.click();
    }

    public boolean isOrderConfirmed() {
        return orderConfirmationMessage.isElementPresent();
    }
}