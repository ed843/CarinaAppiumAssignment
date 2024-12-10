package com.saucelabs.tests;

import com.saucelabs.pages.android.LoginPage;
import com.saucelabs.pages.common.LoginPageBase;
import com.saucelabs.pages.common.MenuPageBase;
import com.saucelabs.pages.common.ProductPageBase;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuTests extends AbstractTest {
    @Test(description = "Verify that the user can sign out using the navbar")
    @MethodOwner(owner = "eduncan")
    public void signOutTest() {
        LoginPageBase loginPage = new LoginPage(getDriver());
        loginPage.clickStandardUser();
        ProductPageBase productPage = loginPage.clickLoginButton();
        MenuPageBase menuPage = productPage.getNavigationBar().openMenu();
        menuPage.clickLogout();
        Assert.assertTrue(loginPage.isLoginPagePresent());
    }
}
