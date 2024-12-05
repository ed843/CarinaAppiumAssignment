package com.saucelabs.pages.android;

import com.saucelabs.pages.common.LoginPageBase;
import com.saucelabs.pages.common.ProductDetailsPageBase;
import com.saucelabs.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductDetailsPageBase.class)
public class ProductDetailsPage extends ProductDetailsPageBase implements IMobileUtils {
    @FindBy(xpath="//android.widget.TextView[@text=\"BACK TO PRODUCTS\"]")
    ExtendedWebElement backToProductsButton;

    @FindBy(xpath="//android.widget.TextView[@text=\"ADD TO CART\"]")
    ExtendedWebElement addToCartButton;

    @FindBy(xpath="//android.widget.TextView[@text=\"REMOVE\"]")
    ExtendedWebElement removeButton;


    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductPageBase backToProductPage() {
        backToProductsButton.click();
        return initPage(getDriver(), ProductPageBase.class);
    }

    @Override
    public void addToCart() {
        addToCartButton.click();
    }

    @Override
    public void removeFromCart() {
        removeButton.click();
    }
}
