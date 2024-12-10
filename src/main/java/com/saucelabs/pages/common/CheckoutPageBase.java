package com.saucelabs.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

public abstract class CheckoutPageBase extends AbstractPage {


    public CheckoutPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeFirstName(String firstName);
    public abstract void typeLastName(String lastName);
    public abstract void typeZipCode(String zipCode);

    public abstract ProductPageBase clickCancel();
    public abstract CheckoutOverviewPageBase clickContinue();

}
