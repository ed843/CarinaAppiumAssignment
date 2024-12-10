package com.saucelabs.pages.android;

import com.saucelabs.pages.common.CheckoutCompletePageBase;
import com.saucelabs.pages.common.CheckoutOverviewPageBase;
import com.saucelabs.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutOverviewPageBase.class)
public class CheckoutOverviewPage extends CheckoutOverviewPageBase implements IAndroidUtils {

    @ExtendedFindBy(accessibilityId = "test-CANCEL")
    private ExtendedWebElement cancelButton;

    @ExtendedFindBy(accessibilityId = "test-FINISH")
    private ExtendedWebElement finishButton;

    @FindBy(className= "android.widget.ScrollView")
    private ExtendedWebElement scrollableContainer;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductPageBase clickCancel() {
        cancelButton.click();
        return initPage(getDriver(), ProductPageBase.class);
    }

    @Override
    public CheckoutCompletePageBase clickFinish() {
        swipe(finishButton, scrollableContainer, 10);
        finishButton.click();
        return initPage(getDriver(), CheckoutCompletePageBase.class);
    }
}
