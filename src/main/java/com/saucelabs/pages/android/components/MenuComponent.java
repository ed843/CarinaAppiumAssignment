package com.saucelabs.pages.android.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//  unused as this resulted in stale element exceptions
public class MenuComponent extends AbstractUIObject {

    @ExtendedFindBy(accessibilityId = "test-ALL ITEMS")
    private ExtendedWebElement allItemsButton;

    @ExtendedFindBy(accessibilityId = "test-LOGOUT")
    private ExtendedWebElement logoutButton;

    @ExtendedFindBy(accessibilityId = "test-ABOUT")
    private ExtendedWebElement aboutButton;

    @ExtendedFindBy(accessibilityId = "test-RESET APP STATE")
    private ExtendedWebElement resetAppButton;

    public MenuComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickAllItems() {
        allItemsButton.click();
    }

    public void clickLogout() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();
    }

    public void clickAbout() {
        aboutButton.click();
    }

    public void resetAppState() {
        resetAppButton.click();
    }
}