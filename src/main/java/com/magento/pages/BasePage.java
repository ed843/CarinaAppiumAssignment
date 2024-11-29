package com.magento.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class BasePage extends AbstractPage {
    public BasePage(WebDriver driver) {
        super(driver);
    }
}
