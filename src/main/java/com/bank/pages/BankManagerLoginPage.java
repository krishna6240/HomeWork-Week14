package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class BankManagerLoginPage extends Utility {
    public BankManagerLoginPage() {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    WebElement _addCustomerLink;

    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    WebElement _openAccountLink;

    @FindBy(xpath = "//button[contains(text(),'Customers')]")
    WebElement _customersLink;


    public void clickOnAddCustomerLink() {
        Reporter.log(" Clicking on add customer link" + _addCustomerLink.toString() + "<br>");
        clickOnElement(_addCustomerLink);


    }

    public void clickOnOpenAccountLink() {
        Reporter.log(" Clicking on open account link" + _openAccountLink.toString() + "<br>");
        clickOnElement(_openAccountLink);

    }

    public void clickOnCustomersLink() {
        Reporter.log(" Clickink on customer link" + _customersLink.toString() + "<br>");
        clickOnElement(_customersLink);

    }

}
