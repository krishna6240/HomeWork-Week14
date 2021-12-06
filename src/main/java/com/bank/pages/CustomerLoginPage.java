package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CustomerLoginPage extends Utility {
    public CustomerLoginPage() {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement _searchCreatedcustomerName;

    @FindBy(xpath = "//button[@class='btn btn-default']")
    WebElement _loginBtn;

    @FindBy(xpath = "//label[contains(text(),'Your Name :')]")
    WebElement _verifyYourNameText;


    public void clickOnLoginButton() {
        Reporter.log(" Clicking onn login button" + _loginBtn.toString() + "<br>");
        clickOnElement(_loginBtn);

    }


    public void assertYourNameText(String yourNameTxt) {
        Reporter.log("Verify your name text " + yourNameTxt + " displayed on login page" + _verifyYourNameText.toString() + "<br>");
        verifyText(_verifyYourNameText, "Your Name :");

    }
}
