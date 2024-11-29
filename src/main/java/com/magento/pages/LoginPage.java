package com.magento.pages;


import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    @FindBy(css = "#email")
    private ExtendedWebElement emailInput;

    @FindBy(css = "#pass")
    private ExtendedWebElement passwordInput;

    @FindBy(css = ".action.login")
    private ExtendedWebElement loginButton;

    @FindBy(css = ".page .messages")
    private ExtendedWebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {

        // Wait for any overlays to disappear
        emailInput.type(email);
        passwordInput.type(password);
        clickLoginButton();
    }

    private void clickLoginButton() {
        try {
            loginButton.click();
        } catch (ElementClickInterceptedException e) {
            // Fallback to JavaScript click
            ((JavascriptExecutor) getDriver())
                    .executeScript("arguments[0].click();",
                            loginButton.getElement());
        }
    }

    // Added method to check error message
    public boolean isErrorMessageDisplayed() {
        return errorMessage.isElementPresent();
    }
}