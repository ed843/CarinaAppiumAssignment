package com.saucelabs.pages.android;

import com.saucelabs.enums.FilterOption;
import com.saucelabs.enums.Product;
import com.saucelabs.pages.android.components.NavigationBar;
import com.saucelabs.pages.common.LoginPageBase;
import com.saucelabs.pages.common.ProductDetailsPageBase;
import com.saucelabs.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]")
    private NavigationBar navigationBar;

    @FindBy(xpath="//android.widget.TextView[@text=\"PRODUCTS\"]")
    private ExtendedWebElement title;

    @FindBy(xpath="//android.view.ViewGroup[@content-desc=\"test-Toggle\"]")
    private ExtendedWebElement toggleLayoutView;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
    private ExtendedWebElement filterButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return title.isElementPresent();
    }

    @Override
    public ProductDetailsPageBase clickOnProduct(Product productName) {
        String xpath = "//android.widget.TextView[@content-desc=\"test-Item title\" and @text=\"" + productName.getValue() + "\"]/..";
        ExtendedWebElement productCard = findExtendedWebElement(By.xpath(xpath));
        productCard.click();
        return initPage(getDriver(), ProductDetailsPageBase.class);
    }

    @Override
    public void clickOnLayoutView() {
        toggleLayoutView.click();
    }

    @Override
    public void addProductToCart(Product productName) {
        String xpath = "//android.widget.TextView[@content-desc=\"test-Item title\" and @text=\"" + productName.getValue() + "\"]/..//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]";
        ExtendedWebElement addToCartButton = findExtendedWebElement(By.xpath(xpath));
        addToCartButton.click();
    }

    @Override
    public void openFilterModal() {
        filterButton.click();
    }

    @Override
    public void sortProducts(FilterOption option) {
        String xpath = "//android.widget.TextView[@text=\"" + option.getValue() + "\"]";
        ExtendedWebElement sortButton = findExtendedWebElement(By.xpath(xpath));
        sortButton.click();
    }

    @Override
    public NavigationBar getNavigationBar() {
        return navigationBar;
    }


}
