package com.saucelabs.pages.android;

import com.saucelabs.pages.common.CartPageBase;
import com.saucelabs.pages.common.CheckoutPageBase;
import com.saucelabs.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase implements IMobileUtils {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @ExtendedFindBy(accessibilityId = "test-CONTINUE SHOPPING")
    public ExtendedWebElement continueShoppingButton;

    @ExtendedFindBy(accessibilityId = "test-CHECKOUT")
    public ExtendedWebElement checkoutButton;

    @Override
    public void removeFromCart(int index) {
        String xpath = "(//android.view.ViewGroup[@content-desc=\"test-REMOVE\"])[" + index + "]";
        ExtendedWebElement deleteProductButton = findExtendedWebElement(By.xpath(xpath));
        deleteProductButton.click();
    }

    @Override
    public boolean isCartEmpty() {
        String xpath= "(//android.view.ViewGroup[@content-desc=\"test-Item\"])";
        return findExtendedWebElements(By.xpath(xpath)).isEmpty();

    }

    @Override
    public ProductPageBase clickContinueShopping() {
        continueShoppingButton.click();
        return initPage(getDriver(), ProductPageBase.class);
    }

    @Override
    public CheckoutPageBase clickContinueCheckout() {
        checkoutButton.click();
        return initPage(getDriver(), CheckoutPageBase.class);
    }
}
