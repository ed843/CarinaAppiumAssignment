package com.saucelabs.tests;

import com.saucelabs.enums.Product;
import com.saucelabs.pages.android.CheckoutCompletePage;
import com.saucelabs.pages.android.LoginPage;
import com.saucelabs.pages.common.*;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckoutTests extends AbstractTest {
    @DataProvider(name = "productData")
    public Object[][] productData() {
        return new Object[][]{
                {Product.BACKPACK, "Eric", "Duncan", "38291"},
                {Product.BIKE_LIGHT, "John", "Doe", "29301"}

        };
    }


    @Test(dataProvider = "productData", description = "Verify checkout user flow")
    @MethodOwner(owner = "eduncan")
    public void testProductUserFlow(Product product, String firstName, String lastName, String zipCode) {
        LoginPageBase loginPage = new LoginPage(getDriver());
        loginPage.clickStandardUser();
        ProductPageBase productPage = loginPage.clickLoginButton();
        productPage.addProductToCart(product);
        CartPageBase cartPage = productPage.getNavigationBar().openCart();
        CheckoutPageBase checkoutPage = cartPage.clickContinueCheckout();
        checkoutPage.typeFirstName(firstName);
        checkoutPage.typeLastName(lastName);
        checkoutPage.typeZipCode(zipCode);
        CheckoutOverviewPageBase checkoutOverviewPage = checkoutPage.clickContinue();
        CheckoutCompletePageBase checkoutCompletePage = checkoutOverviewPage.clickFinish();
        checkoutCompletePage.clickBackHome();
        Assert.assertTrue(productPage.isPageOpened());
    }

    @Test(description = "Verify cancel button brings user back to product page")
    @MethodOwner(owner = "eduncan")
    public void testCancelButton() {
        LoginPageBase loginPage = new LoginPage(getDriver());
        loginPage.clickStandardUser();
        ProductPageBase productPage = loginPage.clickLoginButton();
        productPage.addProductToCart(Product.BACKPACK);
        CartPageBase cartPage = productPage.getNavigationBar().openCart();
        CheckoutPageBase checkoutPage = cartPage.clickContinueCheckout();
        checkoutPage.clickCancel();
        Assert.assertTrue(productPage.isPageOpened());
    }

    @Test(description = "Verify cart item removal")
    @MethodOwner(owner = "eduncan")
    public void testRemoveFromCart() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickStandardUser();
        ProductPageBase productPage = loginPage.clickLoginButton();

        productPage.addProductToCart(Product.BACKPACK);
        CartPageBase cartPage = productPage.getNavigationBar().openCart();
        cartPage.removeFromCart(1);

        Assert.assertTrue(cartPage.isCartEmpty());
        productPage = cartPage.clickContinueShopping();
        Assert.assertTrue(productPage.isPageOpened(),
                "Should return to products page");
    }
}
