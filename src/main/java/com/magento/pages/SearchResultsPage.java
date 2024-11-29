package com.magento.pages;


import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class SearchResultsPage extends BasePage {
    @FindBy(css = ".product-item")
    private List<ExtendedWebElement> searchResults;

    @FindBy(css = ".toolbar-amount")
    private ExtendedWebElement searchResultCount;

    @FindBy(css = ".filter-options-title")
    private List<ExtendedWebElement> filterOptions;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public int getSearchResultCount() {
        return searchResults.size();
    }

    public boolean hasResults() {
        return !searchResults.isEmpty();
    }

    public void applyFilter(String filterType) {
        for (ExtendedWebElement filter : filterOptions) {
            if (filter.getText().trim().equalsIgnoreCase(filterType)) {
                filter.click();
                break;
            }
        }
    }

    public ProductPage selectFirstProduct() {
        if (!searchResults.isEmpty()) {
            searchResults.get(0).click();
            return new ProductPage(getDriver());
        }
        return null;
    }
}