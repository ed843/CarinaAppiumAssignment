package com.magento.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
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
        if (index < removeItemButtons.size()) {
            removeItemButtons.get(index).click();
        }
    }

    public void addItemToCart(int index) {
        if (index < addToCartButtons.size()) {
            addToCartButtons.get(index).click();
        }
    }

    public boolean isWishlistEmpty() {
        return wishlistItems.isEmpty();
    }
}