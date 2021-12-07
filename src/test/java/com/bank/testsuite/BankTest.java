package com.bank.testsuite;

import com.bank.customlisteners.CustomListeners;
import com.bank.pages.*;
import com.bank.testbase.Testbase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(CustomListeners.class)
public class BankTest extends Testbase {
    String firstName = null;
    String lastName = null;


    HomePage homePage;
    BankManagerLoginPage bankManagerLoginPage;
    AddCustomerPage addCustomerPage;
    OpenAccountPage openAccountPage;
    CustomersPage customersPage;
    CustomerLoginPage customerLoginPage;
    AccountPage accountPage;

    @BeforeMethod(groups = {"regression", "smoke", "sanity"})
    public void inTt() {

        homePage = new HomePage();
        bankManagerLoginPage = new BankManagerLoginPage();
        addCustomerPage = new AddCustomerPage();
        openAccountPage = new OpenAccountPage();
        customersPage = new CustomersPage();
        customerLoginPage = new CustomerLoginPage();
        accountPage = new AccountPage();

    }


    @BeforeTest(groups = {"regression", "sanity", "smoke"})
    public void setUp1() {
        firstName = getRandomString(4);
        lastName = getRandomString(5);
    }

    @Test(groups = {"sanity", "regression"})
    public void bankManagerShouldAddCustomerSuccessfully() {
        homePage.clickOnBankManagerLoginLink();
        bankManagerLoginPage.clickOnAddCustomerLink();
        addCustomerPage.enterFirstName(firstName);
        addCustomerPage.enterLastName(lastName);
        addCustomerPage.enterPostCode("HA3");
        addCustomerPage.clickOnAddCustomerButton();
        addCustomerPage.verifyMessageFromPopupOnAddCustomerPage("Customer added successfully with customer id :");
        acceptAlert();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void bankManagerShouldOpenAccountSuccessfully() {
        homePage.clickOnHomeButton();
        homePage.clickOnBankManagerLoginLink();
        bankManagerLoginPage.clickOnOpenAccountLink();
        openAccountPage.clickOnSearchCustomerField();
        openAccountPage.enterCustomerThatCreatedInFirstTest("Harry Potter");
        openAccountPage.clickOnSearchCurrencyField();
        openAccountPage.clickOnSearchCurrencyFieldPound("Pound");
        openAccountPage.clickOnProcessButton();
        openAccountPage.verifyMessageFromPopupOnOpenAccountPage("Account created successfully with account Number :");
        acceptAlert();
    }

    @Test(groups = {"smoke", "regression"})
    public void customerShouldLoginAndLogoutSuccessfully() {
        homePage.clickOnHomeButton();
        homePage.clickOnCustomerLoginLink();
        openAccountPage.clickOnSearchCustomerField();
        openAccountPage.enterCustomerThatCreatedInFirstTest("Harry Potter");
        customerLoginPage.clickOnLoginButton();
        accountPage.assertLogOutText("Logout");
        accountPage.clickOnLogOutButton();
        customerLoginPage.assertYourNameText("Your Name :");
    }

    @Test(groups = {"smoke", "regression"})
    public void customerShouldDepositeMoneySuccessfully() {
        homePage.clickOnHomeButton();
        homePage.clickOnCustomerLoginLink();
        openAccountPage.clickOnSearchCustomerField();
        openAccountPage.enterCustomerThatCreatedInFirstTest("Harry Potter");
        //  customerLoginPage.clickOnSearchCreatedCustomerName();
        customerLoginPage.clickOnLoginButton();
        accountPage.clickOnDepositeTab();
        accountPage.enterdDepositAmount100(100);
        accountPage.clickOnDepositeButton();
        accountPage.assertDepositeSuccessfulText("Deposit Successful");
    }

    @Test(groups = {"regression"})
    public void customerShouldWithdrawMoneySuccessfully() {
        homePage.clickOnHomeButton();
        homePage.clickOnCustomerLoginLink();
        openAccountPage.clickOnSearchCustomerField();
        openAccountPage.enterCustomerThatCreatedInFirstTest("Harry Potter");
        customerLoginPage.clickOnLoginButton();
        accountPage.clickOnWithdrawlTab();
        accountPage.enterWithdrawlAmount50("50");
        accountPage.clicOnWithdrawlButton();


    }


}
