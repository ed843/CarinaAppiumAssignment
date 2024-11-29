package com.magento.tests;

import com.magento.pages.*;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTests extends AbstractTest {
    @Test(description = "Verify adding product to cart")
    public void testAddProductToCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        // Navigate to a specific product category
        homePage.navigateToCategory("Mens Jackets");

        ProductPage productPage = homePage.selectFirstProduct();
        productPage.selectSize("M");
        productPage.selectColor("Blue");
        productPage.addToCart();

        CartPage cartPage = new CartPage(getDriver());
        Assert.assertTrue(cartPage.isProductInCart(), "Product not added to cart");
    }

    @Test(description = "Verify adding product to wishlist")
    public void testAddProductToWishlist() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        // Ensure user is logged in
        homePage.login("test_user@example.com", "StrongPassword123!");

        homePage.navigateToCategory("Womens Tops");
        ProductPage productPage = homePage.selectFirstProduct();
        productPage.addToWishlist();

        WishlistPage wishlistPage = new WishlistPage(getDriver());
        Assert.assertTrue(wishlistPage.getWishlistItemCount() > 0,
                "Product not added to wishlist");
    }

    @Test(description = "Verify product comparison functionality")
    public void testCompareProducts() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        homePage.navigateToCategory("Mens Jackets");

        // Add multiple products to comparison
        ProductPage firstProduct = homePage.selectFirstProduct();
        firstProduct.addToCompare();

        homePage.navigateToCategory("Mens Jackets");
        ProductPage secondProduct = homePage.selectSecondProduct();
        secondProduct.addToCompare();

        CompareProductsPage comparePage = homePage.navigateToCompareProducts();
        Assert.assertEquals(comparePage.getComparedProductCount(), 2,
                "Incorrect number of products in comparison");
    }
}
