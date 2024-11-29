package com.magento.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WishlistPage extends BasePage {
    @FindBy(css = ".product-item-details")
    private List<ExtendedWebElement> wishlistItems;

    @FindBy(css = ".action.delete")
    private List<ExtendedWebElement> removeItemButtons;

    @FindBy(css = ".action.tocart")
    private List<ExtendedWebElement> addToCartButtons;

    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    public int getWishlistItemCount() {
        return wishlistItems.size();
    }

    public void removeItemFromWishlist(int index) {
        // Wait for the product item to be present
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        // Find and hover over the product item
        ExtendedWebElement wishlistOptions = findExtendedWebElement(
                By.cssSelector(".product-item-info")
        );

        try {
            // Scroll element into view first
            ((JavascriptExecutor) getDriver()).executeScript(
                    "arguments[0].scrollIntoView(true);",
                    wishlistOptions.getElement()
            );

            // Wait for hover effect to be possible
            wait.until(ExpectedConditions.elementToBeClickable(wishlistOptions.getElement()));
            wishlistOptions.hover();

            // Wait for remove button to be clickable after hover
            if (index < removeItemButtons.size()) {
                ExtendedWebElement removeButton = removeItemButtons.get(index);
                wait.until(ExpectedConditions.elementToBeClickable(removeButton.getElement()));

                try {
                    removeButton.click();
                } catch (ElementNotInteractableException e) {
                    // Fallback to JavaScript click
                    ((JavascriptExecutor) getDriver()).executeScript(
                            "arguments[0].click();",
                            removeButton.getElement()
                    );
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to remove item from wishlist: " + e.getMessage());
        }
    }

    public void addItemToCart(int index) {
        // Wait for the product item to be present
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        // Find and hover over the product item
        ExtendedWebElement wishlistOptions = findExtendedWebElement(
                By.cssSelector(".product-item-info")
        );

        try {
            // Scroll element into view first
            ((JavascriptExecutor) getDriver()).executeScript(
                    "arguments[0].scrollIntoView(true);",
                    wishlistOptions.getElement()
            );

            // Wait for hover effect to be possible
            wait.until(ExpectedConditions.elementToBeClickable(wishlistOptions.getElement()));
            wishlistOptions.hover();

            // Wait for remove button to be clickable after hover
            if (index < addToCartButtons.size()) {
                ExtendedWebElement addToCartButton = addToCartButtons.get(index);
                wait.until(ExpectedConditions.elementToBeClickable(addToCartButton.getElement()));

                try {
                    addToCartButton.click();
                } catch (ElementNotInteractableException e) {
                    // Fallback to JavaScript click
                    ((JavascriptExecutor) getDriver()).executeScript(
                            "arguments[0].click();",
                            addToCartButton.getElement()
                    );
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to remove item from wishlist: " + e.getMessage());
        }
    }

    public boolean isWishlistEmpty() {
        return wishlistItems.isEmpty();
    }
}