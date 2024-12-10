package com.saucelabs.pages.common;

import com.saucelabs.enums.FilterOption;
import com.saucelabs.enums.Product;
import com.saucelabs.pages.android.ProductDetailsPage;
import com.saucelabs.pages.android.components.NavigationBar;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductPageBase extends AbstractPage {
    public ProductPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();

    public abstract ProductDetailsPageBase clickOnProduct(Product productName);

    public abstract void clickOnLayoutView();

    public abstract void addProductToCart(Product productName);

    public abstract void openFilterModal();

    public abstract void sortProducts(FilterOption option);

    public abstract NavigationBar getNavigationBar();

}
