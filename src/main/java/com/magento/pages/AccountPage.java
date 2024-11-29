package com.magento.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {
    @FindBy(css = ".block-dashboard-info")
    private ExtendedWebElement accountInfoSection;

    @FindBy(css = ".block-orders")
    private ExtendedWebElement orderHistorySection;

    @FindBy(css = ".action.change-password")
    private ExtendedWebElement changePasswordLink;

    @FindBy(css = ".action.edit")
    private ExtendedWebElement editAccountInfoLink;

    @FindBy(css = ".box-information")
    private ExtendedWebElement contactInformation;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountInfoDisplayed() {
        return accountInfoSection.isElementPresent();
    }

    public void navigateToOrderHistory() {
        orderHistorySection.click();
    }

    public void changePassword() {
        changePasswordLink.click();
    }

    public void editAccountInfo() {
        editAccountInfoLink.click();
    }

    public String getContactInformation() {
        return contactInformation.getText();
    }
}
