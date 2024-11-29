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

    @FindBy(css = ".swatch-option")
    private List<ExtendedWebElement> sizeOptions;

    @FindBy(css = ".swatch-color")
    private List<ExtendedWebElement> colorOptions;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void selectSize(String size) {
        for (ExtendedWebElement sizeOption : sizeOptions) {
            if (sizeOption.getText().equalsIgnoreCase(size)) {
                sizeOption.click();
                return;
            }
        }
        throw new RuntimeException("Size not found: " + size);
    }

    public void selectColor(String color) {
        for (ExtendedWebElement colorOption : colorOptions) {
            if (colorOption.getAttribute("data-option-label").equalsIgnoreCase(color)) {
                colorOption.click();
                return;
            }
        }
        throw new RuntimeException("Color not found: " + color);
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public void addToWishlist() {
        // Method 1: Using JavaScript Executor
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", addToWishlistButton.getElement());
    }

    // Added method for adding to compare
    public void addToCompare() {
        ExtendedWebElement compareButton = findExtendedWebElement(By.cssSelector(".action.tocompare"));
        compareButton.click();
    }
}
