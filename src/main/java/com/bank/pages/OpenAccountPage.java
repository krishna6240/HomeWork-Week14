package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class OpenAccountPage extends Utility {
    public OpenAccountPage() {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement _searchCustomerField;

    @FindBy(xpath = "//select[@id='currency']" )
    WebElement _searchCurrencyPound;

    @FindBy(xpath = "//button[contains(text(),'Process')]" )
    WebElement _processBtn;


    public void clickOnSearchCustomerField() {
        Reporter.log(" Clicking on search customer field" + _searchCustomerField.toString() + "<br>");
        clickOnElement(_searchCustomerField);

    }

    public void enterCustomerThatCreatedInFirstTest(String cusName) {
        Reporter.log(" Enter name" + cusName+" on customer name field "+ _searchCustomerField.toString()+"<br>");
        selectByVisibleTextFromDropDown(_searchCustomerField, cusName);


    }

    public void clickOnSearchCurrencyField() {
        Reporter.log(" clicking on Pound currency field" + _searchCurrencyPound.toString()+"<br>");
        clickOnElement(_searchCurrencyPound);

    }

    public void clickOnSearchCurrencyFieldPound(String poundField) {
        Reporter.log("Search Pound field" + poundField+" from currency " + _searchCurrencyPound.toString()+"<br>");
        selectByVisibleTextFromDropDown(_searchCurrencyPound, poundField);

    }

    public void clickOnProcessButton() {
        Reporter.log("Clicking on process button" + _processBtn.toString()+"<br>");
        clickOnElement(_processBtn);
        //    log.info("Clicking onprocess button" + _processBtn.toString());
    }

    public void verifyMessageFromPopupOnOpenAccountPage(String str) {
        String actualMessage = getTextFromAlert();
        String expectedMessage = "Account created successfully with account Number :";
        Assert.assertTrue(actualMessage.contains(expectedMessage), str);
        //    alertAccept();


    }

}
