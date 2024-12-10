package com.saucelabs.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
//(//android.view.ViewGroup[@content-desc="test-REMOVE"])[1]
//(//android.view.ViewGroup[@content-desc="test-REMOVE"])[2]
public abstract class CartPageBase extends AbstractPage {
    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isCartEmpty();
    public abstract void removeFromCart(int index);
    public abstract ProductPageBase clickContinueShopping();
    public abstract CheckoutPageBase clickContinueCheckout();


}
