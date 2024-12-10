package com.saucelabs.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public abstract class MenuPageBase extends AbstractPage {
    public MenuPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickAllItems();

    public abstract  void clickLogout();

    public abstract void clickAbout();

    public abstract void resetAppState();
}
