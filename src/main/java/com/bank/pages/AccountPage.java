package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class AccountPage extends Utility {
    public AccountPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@class='btn logout']")
    WebElement _verifylogOutText;

    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    WebElement _depositeTab;

    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement _amountToBeDepositedField;

    @FindBy(xpath = "//button[@class='btn btn-default']")
    WebElement _depositebtn;

    @FindBy(xpath = "//span[@class='error ng-binding']")
    WebElement _verifyDepositSuccessfulText;

    @FindBy(xpath = "//button[contains(text(),'Withdrawl')]")
    WebElement _withdrawlTab;

    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement _amountToBeWithdrawlsField;

    @FindBy(xpath = "//button[@class='btn btn-default']")
    WebElement _withdrawlBtn;

    @FindBy(xpath = "//span[@class='error ng-binding']")
    WebElement verifyTransactionSuccessfulText;

    public void assertLogOutText(String logOutTxt) {
        Reporter.log(" Verify logout text " + logOutTxt + " dispalyed on login page" + _verifylogOutText.toString() + "<br>");
        verifyText(_verifylogOutText, "Logout");

    }

    public void clickOnLogOutButton() {
        Reporter.log(" Click on logout button " + _verifylogOutText.toString() + "<br>");
        clickOnElement(_verifylogOutText);

    }

    // Method for click ondeposit tab
    public void clickOnDepositeTab() {
        Reporter.log(" Click on deposit tab " + _depositeTab.toString() + "<br>");
        clickOnElement(_depositeTab);


    }

    // Method for enter deposit field
    public void enterdDepositAmount100(int amount) {
        Reporter.log(" Enter £100 on deposit field " + _amountToBeDepositedField.toString() + "<br>");
        sendTextToElement(this._amountToBeDepositedField, String.valueOf(amount));

    }

    // Method for Click on deposit button
    public void clickOnDepositeButton() {
        Reporter.log(" Clicking on deposite button " + _depositebtn.toString() + "<br>");
        clickOnElement(_depositebtn);

    }

    public void assertDepositeSuccessfulText(String depSuccessTxt) {
        Reporter.log(" Verify Deposite successful text " + depSuccessTxt + " displayed on account page" + _verifyDepositSuccessfulText.toString() + "<br>");
        verifyText(_verifyDepositSuccessfulText, "Deposit Successful");

    }

    public void clickOnWithdrawlTab() {
        Reporter.log(" Clicking withdrawal tab" + _withdrawlTab.toString() + "<br>");
        clickOnElement(_withdrawlTab);

    }

    public void enterWithdrawlAmount50(String withdrawalAmt) {
        Reporter.log(" Enter £50 in withdrawal field" + withdrawalAmt + " to withdraw money" + _amountToBeWithdrawlsField.toString() + "<br>");
        sendTextToElement(_amountToBeWithdrawlsField, withdrawalAmt);

    }

    public void clicOnWithdrawlButton() {
        Reporter.log(" Clicking withdrawal button " + _withdrawlBtn.toString() + " <br>");
        clickOnElement(_withdrawlBtn);

    }

    public void assertTransactionSuccessfulText(String tranSuccessTxt) {
        Reporter.log(" Verify transaction success text " + tranSuccessTxt + " for withdrawal amt" + _verifyDepositSuccessfulText.toString() + " <br>");
        verifyText(verifyTransactionSuccessfulText, "Transaction successful");

    }
}
