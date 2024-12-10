package com.saucelabs.pages.android.components;

import com.saucelabs.pages.common.CartPageBase;
import com.saucelabs.pages.common.MenuPageBase;
import com.saucelabs.pages.common.ProductPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

public class NavigationBar extends AbstractUIObject {


    @FindBy(xpath="//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView")
    private ExtendedWebElement menuButton;

    @FindBy(xpath="//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView")
    private ExtendedWebElement cartButton;

    public NavigationBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public MenuPageBase openMenu() {
        menuButton.click();
        return initPage(getDriver(), MenuPageBase.class);
    }

    public CartPageBase openCart() {
        cartButton.click();
        return initPage(getDriver(), CartPageBase.class);
    }
}
