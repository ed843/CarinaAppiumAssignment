package com.magento.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CompareProductsPage extends BasePage {
    @FindBy(css = ".compare-table")
    private ExtendedWebElement compareTable;

    @FindBy(css = ".product-item-name")
    private List<ExtendedWebElement> comparedProductNames;

    @FindBy(css = ".action.delete")
    private List<ExtendedWebElement> removeCompareButtons;

    @FindBy(css = ".action.tocart")
    private List<ExtendedWebElement> addToCartButtons;

    public CompareProductsPage(WebDriver driver) {
        super(driver);
    }

    public int getComparedProductCount() {
        return comparedProductNames.size();
    }

    public List<String> getComparedProductNames() {
        return comparedProductNames.stream()
                .map(ExtendedWebElement::getText)
                .collect(java.util.stream.Collectors.toList());
    }

    public void removeProductFromCompare(int index) {
        if (index < removeCompareButtons.size()) {
            removeCompareButtons.get(index).click();
        }
    }

    public void addProductToCart(int index) {
        if (index < addToCartButtons.size()) {
            addToCartButtons.get(index).click();
        }
    }

    public boolean isCompareTableVisible() {
        return compareTable.isElementPresent();
    }
}