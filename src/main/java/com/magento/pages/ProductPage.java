package com.magento.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductPage extends BasePage {
    @FindBy(css = ".product-add-form")
    private ExtendedWebElement addToCartForm;

    @FindBy(css = ".action.tocart")
    private ExtendedWebElement addToCartButton;

    @FindBy(css = ".action.towishlist")
    private ExtendedWebElement addToWishlistButton;

    @FindBy(css = ".swatch-option.text")
    private List<ExtendedWebElement> sizeOptions;

    @FindBy(css = ".swatch-option.color")
    private List<ExtendedWebElement> colorOptions;

    @FindBy(css = ".counter-number")
    private ExtendedWebElement counterNumber;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void selectSize(String size) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        for (ExtendedWebElement sizeOption : sizeOptions) {
            if (sizeOption.getText().equalsIgnoreCase(size)) {
                js.executeScript("arguments[0].click();", sizeOption.getElement());
                return;
            }
        }
        throw new RuntimeException("Size not found: " + size);
    }

    public void selectColor(String color) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        for (ExtendedWebElement colorOption : colorOptions) {
            // Use title attribute instead of data-option-label
            String colorValue = colorOption.getAttribute("option-label");


            if (colorValue != null && colorValue.equalsIgnoreCase(color)) {
                js.executeScript("arguments[0].click();", colorOption.getElement());
                return;
            }
        }
        throw new RuntimeException("Color not found: " + color);
    }

    public void addToCart() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", addToCartButton.getElement());
    }

    public boolean isProductInCart() {
        return counterNumber.isDisplayed();
    }

    public void addToWishlist() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", addToWishlistButton.getElement());
    }

    // Added method for adding to compare
    public void addToCompare() {
        ExtendedWebElement compareButton = findExtendedWebElement(By.cssSelector(".action.tocompare"));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", compareButton.getElement());
    }

    public CheckoutPage navigateToCheckout() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        ExtendedWebElement cartButton = findExtendedWebElement(By.cssSelector(".action.showcart"));
        js.executeScript("arguments[0].click();", cartButton.getElement());
        ExtendedWebElement proceedToCheckout = findExtendedWebElement(By.cssSelector("#top-cart-btn-checkout"));
        js.executeScript("arguments[0].click();", proceedToCheckout.getElement());
        return new CheckoutPage(getDriver());
    }
}
