package com.saucelabs.pages.android;

import com.saucelabs.pages.common.CheckoutOverviewPageBase;
import com.saucelabs.pages.common.CheckoutPageBase;
import com.saucelabs.pages.common.ProductDetailsPageBase;
import com.saucelabs.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutPageBase.class)
public class CheckoutPage extends CheckoutPageBase implements IMobileUtils {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @ExtendedFindBy(accessibilityId = "test-First Name")
    public ExtendedWebElement firstNameEntry;

    @ExtendedFindBy(accessibilityId = "test-Last Name")
    public ExtendedWebElement lastNameEntry;

    @ExtendedFindBy(accessibilityId = "test-Zip/Postal Code")
    public ExtendedWebElement zipCodeEntry;

    @ExtendedFindBy(accessibilityId = "test-CANCEL")
    public ExtendedWebElement cancelButton;

    @ExtendedFindBy(accessibilityId = "test-CONTINUE")
    public ExtendedWebElement continueButton;

    @Override
    public void typeFirstName(String firstName) {
        firstNameEntry.type(firstName);
    }

    @Override
    public void typeLastName(String lastName) {
        lastNameEntry.type(lastName);
    }

    @Override
    public void typeZipCode(String zipCode) {
        zipCodeEntry.type(zipCode);
    }

    @Override
    public ProductPageBase clickCancel() {
        cancelButton.click();
        return initPage(getDriver(), ProductPageBase.class);
    }

    @Override
    public CheckoutOverviewPageBase clickContinue() {
        continueButton.click();
        return initPage(getDriver(), CheckoutOverviewPageBase.class);
    }
}
