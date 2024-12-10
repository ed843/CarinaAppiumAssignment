package com.saucelabs.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CheckoutOverviewPageBase extends AbstractPage {

    public CheckoutOverviewPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductPageBase clickCancel();

    public abstract CheckoutCompletePageBase clickFinish();

}
