package com.saucelabs.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CheckoutCompletePageBase extends AbstractPage {


    public CheckoutCompletePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductPageBase clickBackHome();
}
