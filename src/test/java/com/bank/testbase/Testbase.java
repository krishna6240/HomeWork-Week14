package com.bank.testbase;

import com.bank.propertyreader.PropertyReader;
import com.bank.utility.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Testbase extends Utility {
    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod(groups = {"regression","sanity","smoke"})
    public void setUp(){
    selectBrowser(browser);
    }
    @AfterMethod(groups = {"regression","sanity","smoke"})

    public void tearDown(){
        closeBrowser();
    }
}
