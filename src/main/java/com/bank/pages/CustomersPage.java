package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CustomersPage extends Utility {
    public CustomersPage() {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    WebElement _searchCustomerField;

    @FindBy(xpath = "//button[contains(text(),'Delete')]")
    WebElement _deleteCustomer;

    public void clickOnSearchCustomerField() {
        Reporter.log(" Clicking on search customer field" + _searchCustomerField.toString() + "<br>");
        clickOnElement(_searchCustomerField);

    }

    public void enterCustomerThatCreatedInCustomerPage(String customerField) {
        Reporter.log(" Enter text " + customerField + " to search customer field" + _searchCustomerField.toString() + "<br>");
        sendTextToElement(_searchCustomerField, customerField);

    }

    public void clickOnDeleteButton() {
        Reporter.log(" Delete customer " + _deleteCustomer.toString() + "<br>");
        clickOnElement(_deleteCustomer);

    }

}
