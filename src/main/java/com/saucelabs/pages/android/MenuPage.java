package com.saucelabs.pages.android;

import com.saucelabs.pages.common.LoginPageBase;
import com.saucelabs.pages.common.MenuPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MenuPageBase.class)
public class MenuPage extends MenuPageBase implements IMobileUtils {
    @ExtendedFindBy(accessibilityId = "test-ALL ITEMS")
    private ExtendedWebElement allItemsButton;

    @ExtendedFindBy(accessibilityId = "test-LOGOUT")
    private ExtendedWebElement logoutButton;

    @ExtendedFindBy(accessibilityId = "test-ABOUT")
    private ExtendedWebElement aboutButton;

    @ExtendedFindBy(accessibilityId = "test-RESET APP STATE")
    private ExtendedWebElement resetAppButton;

    public MenuPage(WebDriver driver) {
        super(driver);
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
