package com.magento.tests;

import com.magento.pages.HomePage;
import com.magento.pages.ProductPage;
import com.magento.pages.WishlistPage;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishlistTests extends AbstractTest {
    @Test(description = "Add product to wishlist")
    public void testAddToWishlist() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.login("test_user@example.com", "StrongPassword123!");

        // Change to use correct category path
        homePage.navigateToCategory("Women > Tops > Jackets");
        ProductPage productPage = homePage.selectFirstProduct();
        productPage.addToWishlist();

        WishlistPage wishlistPage = new WishlistPage(getDriver());
        Assert.assertTrue(wishlistPage.getWishlistItemCount() > 0,
                "Product not added to wishlist");
    }

    @Test(description = "Remove product from wishlist")
    public void testRemoveFromWishlist() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.login("test_user@example.com", "StrongPassword123!");

        // Navigate directly to wishlist without category navigation
        WishlistPage wishlistPage = homePage.navigateToWishlist();
        int initialCount = wishlistPage.getWishlistItemCount();

        if (initialCount > 0) {
            wishlistPage.removeItemFromWishlist(0);
            Assert.assertTrue(wishlistPage.getWishlistItemCount() < initialCount,
                    "Product not removed from wishlist");
        }
    }

    @Test(description = "Move wishlist item to cart")
    public void testMoveWishlistItemToCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.login("test_user@example.com", "StrongPassword123!");

        // Store initial count for comparison
        WishlistPage wishlistPage = homePage.navigateToWishlist();
        int initialCount = wishlistPage.getWishlistItemCount();

        if (initialCount > 0) {
            wishlistPage.addItemToCart(0);

            // Fix the comparison logic
            Assert.assertTrue(wishlistPage.getWishlistItemCount() < initialCount,
                    "Item not moved from wishlist to cart");
        }
    }
}