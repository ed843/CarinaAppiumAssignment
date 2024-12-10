package com.saucelabs.pages.android;

import com.saucelabs.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.saucelabs.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase implements IMobileUtils {
    @FindBy(xpath="//android.view.ViewGroup[@content-desc=\"test-Error message\"]")
    private ExtendedWebElement errorMessage;

    @FindBy(xpath="//android.widget.ImageView")
    private ExtendedWebElement loginLogo;

    @FindBy(xpath="//android.widget.EditText[@content-desc=\"test-Username\"]")
    ExtendedWebElement usernameField;

    @FindBy(xpath="//android.widget.EditText[@content-desc=\"test-Password\"]")
    ExtendedWebElement passwordField;

    @FindBy(xpath = "//android.widget.TextView[@text=\"LOGIN\"]")
    ExtendedWebElement loginButton;

    @FindBy(xpath = "//android.widget.TextView[@text=\"standard_user\"]")
    ExtendedWebElement standardUserButton;

    @FindBy(xpath = "//android.widget.TextView[@text=\"locked_out_user\"]")
    ExtendedWebElement lockedOutUserButton;

    @FindBy(xpath = "//android.widget.TextView[@text=\"problem_user\"]")
    ExtendedWebElement problemUserButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isErrorMessagePresent() {
        return errorMessage.isElementPresent();
    }

    @Override
    public boolean isLoginPagePresent() {
        return loginButton.isElementPresent();
    }

    @Override
    public void typeUsername(String name) {
        usernameField.type(name);
    }

    @Override
    public void typePassword(String password) {
        passwordField.type(password);
    }

    @Override
    public ProductPageBase clickLoginButton() {
        loginButton.click();
        return initPage(getDriver(), ProductPageBase.class);
    }

    @Override
    public void clickStandardUser() {
        standardUserButton.click();
    }

    @Override
    public void clickLockedOutUser() {
        lockedOutUserButton.click();
    }

    @Override
    public void clickProblemUser() {
        problemUserButton.click();
    }
}
