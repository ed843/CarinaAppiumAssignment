package com.saucelabs.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;


public abstract class LoginPageBase extends AbstractPage {
    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isErrorMessagePresent();
    public abstract void typeUsername(String name);
    public abstract void typePassword(String password);
    public abstract ProductPageBase clickLoginButton();

    public abstract void clickStandardUser();
    public abstract void clickLockedOutUser();
    public abstract void clickProblemUser();
}
