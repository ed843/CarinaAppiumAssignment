package com.magento.pages;


import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class CheckoutPage extends BasePage {
    @FindBy(css = ".control > input[name=\"street[0]\"]")
    private ExtendedWebElement shippingAddressSection;

    @FindBy(css = ".control > input[name=\"city\"]")
    private ExtendedWebElement shippingCitySection;

    @FindBy(css = ".control > select[name=\"region_id\"]")
    private ExtendedWebElement shippingStateSection;

    @FindBy(css = ".control > input[name=\"postcode\"]")
    private ExtendedWebElement shippingZipCodeSection;

    @FindBy(css = ".control > input[name=\"telephone\"]")
    private ExtendedWebElement phoneNumberSection;

    @FindBy(css = "td.col.col-method > input.radio")
    private ExtendedWebElement tableRateOption;

    @FindBy(css = ".button.action.continue.primary")
    private ExtendedWebElement nextButton;

    @FindBy(css = ".payment-method")
    private ExtendedWebElement paymentMethodSection;

    @FindBy(css = ".action.checkout")
    private ExtendedWebElement placeOrderButton;

    @FindBy(css = ".checkout-success")
    private ExtendedWebElement orderConfirmationMessage;

    @FindBy(css = ".shipping-address-item")
    private ExtendedWebElement shippingAddressItem;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void selectShippingAddress(String streetAddress, String city, String state, String zipCode, String phoneNumber) {
        if (shippingAddressItem.isPresent()) { return; } // if already present, skip.
        shippingAddressSection.click();
        shippingAddressSection.type(streetAddress);
        shippingCitySection.click();
        shippingCitySection.type(city);
        shippingStateSection.click();
        shippingStateSection.select(state);
        shippingZipCodeSection.click();
        shippingZipCodeSection.type(zipCode);
        phoneNumberSection.click();
        phoneNumberSection.type(phoneNumber);

    }

    public void selectShippingMethod(String method) {
        tableRateOption.click();
        nextButton.click();
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