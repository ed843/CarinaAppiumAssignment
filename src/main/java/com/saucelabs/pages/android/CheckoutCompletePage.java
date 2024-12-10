package com.saucelabs.pages.android;

import com.saucelabs.pages.common.CheckoutCompletePageBase;
import com.saucelabs.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutCompletePageBase.class)
public class CheckoutCompletePage extends CheckoutCompletePageBase implements IMobileUtils {
    @ExtendedFindBy(accessibilityId = "test-BACK HOME")
    private ExtendedWebElement backHomeButton;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductPageBase clickBackHome() {
        backHomeButton.click();
        return initPage(getDriver(), ProductPageBase.class);
    }
}
