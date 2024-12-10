package com.saucelabs.tests;

import com.saucelabs.enums.FilterOption;
import com.saucelabs.enums.Product;
import com.saucelabs.pages.android.LoginPage;
import com.saucelabs.pages.common.LoginPageBase;
import com.saucelabs.pages.common.ProductDetailsPageBase;
import com.saucelabs.pages.common.ProductPageBase;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTests extends AbstractTest {
    @Test(description = "Verify product sorting functionality")
    @MethodOwner(owner = "eduncan")
    public void testProductSorting() {
        LoginPageBase loginPage = new LoginPage(getDriver());
        loginPage.clickStandardUser();

         ProductPageBase productPage = loginPage.clickLoginButton();

        productPage.openFilterModal();
        productPage.sortProducts(FilterOption.PRICE_HIGH_TO_LOW);

        productPage.openFilterModal();
        productPage.sortProducts(FilterOption.PRICE_LOW_TO_HIGH);

        productPage.openFilterModal();
        productPage.sortProducts(FilterOption.NAME_A_TO_Z);
    }

    @Test(description = "Verify product details view")
    @MethodOwner(owner = "eduncan")
    public void testProductDetails() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickStandardUser();
        ProductPageBase productPage = loginPage.clickLoginButton();

        ProductDetailsPageBase detailsPage = productPage.clickOnProduct(Product.BACKPACK);
        detailsPage.addToCart();
        detailsPage.removeFromCart();

        productPage = detailsPage.backToProductPage();
        Assert.assertTrue(productPage.isPageOpened(),
                "Should return to products page");
    }
}
