package com.saucelabs.pages.common;

import com.saucelabs.pages.android.ProductPage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductDetailsPageBase extends AbstractPage {
    public ProductDetailsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductPageBase backToProductPage();
    public abstract void addToCart();
    public abstract void removeFromCart();
}
