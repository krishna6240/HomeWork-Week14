package com.bank.resources.testdata;

import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name = "credentials")
    public Object[][] getData(){
        return new Object[][]{
                {"krishna","patel","London"},
                {"Samir","Patel","Harrow"},
                {"Veera","Patel","London"},
                {"Parin","Patel","Harrow"}

        };
    }
}
