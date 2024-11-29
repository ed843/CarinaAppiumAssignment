package com.magento.tests;

import com.magento.pages.HomePage;
import com.magento.pages.SearchResultsPage;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTests extends AbstractTest {
    @DataProvider(name = "searchTerms")
    public Object[][] searchTerms() {
        return new Object[][] {
                {"jacket"},
                {"shirt"},
                {"pants"}
        };
    }

    @Test(dataProvider = "searchTerms",
            description = "Verify search functionality")
    public void testSearch(String searchTerm) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        homePage.search(searchTerm);

        SearchResultsPage searchResults = new SearchResultsPage(getDriver());
        Assert.assertTrue(searchResults.hasResults(),
                "No results found for search term: " + searchTerm);
    }

    @Test(description = "Verify advanced search filters")
    public void testSearchFilters() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        homePage.search("jacket");

        SearchResultsPage searchResults = new SearchResultsPage(getDriver());
        searchResults.applyFilter("Price");
        searchResults.applyFilter("Size");

        Assert.assertTrue(searchResults.getSearchResultCount() > 0,
                "Filtering reduced results to zero");
    }
}
