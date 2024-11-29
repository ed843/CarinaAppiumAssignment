package com.magento.tests;

import com.magento.pages.HomePage;
import com.magento.pages.LoginPage;
import com.magento.pages.ProductPage;
import com.magento.pages.CartPage;
import com.magento.pages.CheckoutPage;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTests extends AbstractTest {
    @Test(description = "Complete checkout process")
    public void testCompleteCheckout() {
        // Ensure user is logged in
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LoginPage loginPage = homePage.clickLogin();
        loginPage.login("test_user@example.com", "StrongPassword123!");

        // Add product to cart
        homePage.navigateToCategory("Mens Jackets");
        ProductPage productPage = homePage.selectFirstProduct();
        productPage.selectSize("M");
        productPage.selectColor("Blue");
        productPage.addToCart();

        // Proceed to checkout
        CartPage cartPage = new CartPage(getDriver());
        cartPage.proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(getDriver());

        // Fill checkout details
        checkoutPage.selectShippingAddress("Default");
        checkoutPage.selectShippingMethod("Standard Shipping");
        checkoutPage.selectPaymentMethod("Credit Card");

        // Place order
        checkoutPage.placeOrder();

        // Verify order confirmation
        Assert.assertTrue(checkoutPage.isOrderConfirmed(),
                "Order placement failed");
    }

    @Test(description = "Verify checkout with multiple products")
    public void testMultiProductCheckout() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.login("test_user@example.com", "StrongPassword123!");

        // Add multiple products to cart
        homePage.navigateToCategory("Mens Jackets");
        ProductPage firstProduct = homePage.selectFirstProduct();
        firstProduct.addToCart();

        homePage.navigateToCategory("Womens Tops");
        ProductPage secondProduct = homePage.selectFirstProduct();
        secondProduct.addToCart();

        // Proceed to checkout
        CartPage cartPage = new CartPage(getDriver());
        cartPage.proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(getDriver());
        checkoutPage.placeOrder();

        Assert.assertTrue(checkoutPage.isOrderConfirmed(),
                "Multi-product order placement failed");
    }
}