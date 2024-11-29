package com.magento.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    @FindBy(css = ".cart-items")
    private ExtendedWebElement cartItemsContainer;

    @FindBy(css = ".action.primary.checkout")
    private ExtendedWebElement proceedToCheckoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductInCart() {
        return cartItemsContainer.isElementPresent() &&
                !cartItemsContainer.findExtendedWebElements(By.cssSelector(".cart-item")).isEmpty();
    }

    public void proceedToCheckout() {
        proceedToCheckoutButton.click();
    }
}