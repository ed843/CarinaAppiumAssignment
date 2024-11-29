package com.magento.pages;


import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class HomePage extends BasePage {
    @FindBy(css = ".logo")
    private ExtendedWebElement logo;

    @FindBy(css = "#search")
    private ExtendedWebElement searchInput;

    @FindBy(css = ".authorization-link a")
    private ExtendedWebElement loginLink;

    @FindBy(css = ".navigation .level-top")
    private ExtendedWebElement navigationMenu;

    @FindBy(css = ".block-promo")
    private ExtendedWebElement blockPromoMenu;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isBlockPromoMenuVisible() {
        return blockPromoMenu.isPresent();
    }

    public void search(String query) {
        searchInput.type(query);
        searchInput.sendKeys(Keys.ENTER);
        // Or find and click the search button explicitly
        // searchButton.click();
    }

    public LoginPage clickLogin() {
        loginLink.click();
        return new LoginPage(getDriver());
    }

    public void navigateToCategory(String categoryName) {
        // Wait for menu to be visible and clickable
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        // Split category path
        String[] categories = categoryName.split(" > ");

        // Navigate through each level
        for (int i = 0; i < categories.length; i++) {
            String category = categories[i];

            if (i == 0) {
                // First level navigation
                String xpath = String.format("//nav[@class='navigation']//li[contains(@class, 'level0')]//a[contains(@class, 'level-top')]/span[contains(text(), '%s')]/parent::a", category);
                ExtendedWebElement menuItem = findExtendedWebElement(By.xpath(xpath));
                menuItem.hover();

                if (categories.length == 1) {
                    menuItem.click();
                }
            } else {
                // Submenu navigation
                String xpath = String.format("//nav[@class='navigation']//li[contains(@class, 'level%d')]//a/span[contains(text(), '%s')]/parent::a", i, category);
                ExtendedWebElement menuItem = findExtendedWebElement(By.xpath(xpath));
                menuItem.hover();

                if (i == categories.length - 1) {
                    menuItem.click();
                }
            }

            // Wait for submenu to be visible
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public ProductPage selectFirstProduct() {
        // Wait for product to be visible and clickable
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        // Find the first product with a more specific selector
        ExtendedWebElement firstProduct = findExtendedWebElement(
                By.cssSelector(".product-item-info .product-item-link")
        );

        try {
            // First try scrolling into view
            ((JavascriptExecutor) getDriver()).executeScript(
                    "arguments[0].scrollIntoView(true);",
                    firstProduct.getElement()
            );

            // Wait for element to be clickable
            wait.until(ExpectedConditions.elementToBeClickable(firstProduct.getElement()));

            // Try clicking with JavaScript if normal click fails
            try {
                firstProduct.click();
            } catch (ElementClickInterceptedException e) {
                ((JavascriptExecutor) getDriver()).executeScript(
                        "arguments[0].click();",
                        firstProduct.getElement()
                );
            }

            return new ProductPage(getDriver());
        } catch (Exception e) {
            throw new RuntimeException("Unable to click first product: " + e.getMessage());
        }
    }

    // Added method to select second product
    public ProductPage selectSecondProduct() {
        List<ExtendedWebElement> products = findExtendedWebElements(By.cssSelector(".product-item"));
        if (products.size() > 1) {
            products.get(1).click();
            return new ProductPage(getDriver());
        }
        throw new RuntimeException("Not enough products to select second product");
    }

    // Added login method
    public void login(String username, String password) {
        LoginPage loginPage = clickLogin();
        loginPage.login(username, password);
    }

    // Added method to navigate to wishlist
    public WishlistPage navigateToWishlist() {
        ExtendedWebElement wishlistLink = findExtendedWebElement(By.cssSelector(".wishlist"));
        wishlistLink.click();
        return new WishlistPage(getDriver());
    }

    // Added method to navigate to compare products
    public CompareProductsPage navigateToCompareProducts() {
        ExtendedWebElement compareLink = findExtendedWebElement(By.cssSelector(".compare-link"));
        compareLink.click();
        return new CompareProductsPage(getDriver());
    }
}