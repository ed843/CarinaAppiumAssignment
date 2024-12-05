package com.saucelabs.tests;

import com.saucelabs.pages.android.LoginPage;
import com.saucelabs.pages.common.LoginPageBase;
import com.saucelabs.pages.common.ProductPageBase;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends AbstractTest {
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", "secret_sauce", true},
                {"invalid_user", "wrong_password", false},
                {"locked_out_user", "secret_sauce", false},
                {"problem_user", "secret_sauce", true}
        };
    }

    @Test(dataProvider = "loginData", description = "Verify login with multiple user credentials")
    @MethodOwner(owner = "eduncan")
    public void testLoginAttempts(String username, String password, boolean shouldSucceed) {
        LoginPageBase loginPage = new LoginPage(getDriver());
        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        ProductPageBase productPage = loginPage.clickLoginButton();

        if (shouldSucceed) {
            Assert.assertTrue(productPage.isPageOpened(),
                    "Login should succeed for user: " + username);
        } else {
            Assert.assertTrue(loginPage.isErrorMessagePresent(),
                    "Error message should be displayed for invalid credentials: " + username);
        }
    }
}
