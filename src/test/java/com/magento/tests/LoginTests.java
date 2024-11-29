package com.magento.tests;

import com.magento.pages.HomePage;
import com.magento.pages.LoginPage;
import com.magento.pages.AccountPage;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class LoginTests extends AbstractTest {
    @Test(description = "Verify successful login with valid credentials")
    public void testSuccessfulLogin() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        LoginPage loginPage = homePage.clickLogin();
        loginPage.login("test_user@example.com", "StrongPassword123!");

        HomePage homePage1 = new HomePage(getDriver());
        Assert.assertTrue(homePage1.isBlockPromoMenuVisible(), "Login was unsuccessful");
    }

    @Test(description = "Verify login failure with invalid credentials")
    public void testInvalidLogin() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        LoginPage loginPage = homePage.clickLogin();
        loginPage.login("invalid@email.com", "wrongpassword");

        Assert.assertTrue(loginPage.isErrorMessageDisplayed(),
                "Error message for invalid login not displayed");
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
                {"valid_user@example.com", "ValidPass123!"},
                {"another_user@example.com", "AnotherPass456!"}
        };
    }

    @Test(dataProvider = "loginData",
            description = "Verify login with multiple user credentials")
    public void testMultipleUserLogins(String username, String password) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        LoginPage loginPage = homePage.clickLogin();
        loginPage.login(username, password);

        HomePage homePage1 = new HomePage(getDriver());
        Assert.assertTrue(homePage1.isBlockPromoMenuVisible(),
                "Login failed for user: " + username);
    }
}