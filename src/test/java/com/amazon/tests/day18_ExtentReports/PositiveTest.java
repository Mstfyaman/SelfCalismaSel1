package com.amazon.tests.day18_ExtentReports;

import com.amazon.pages.LoginPages;
import com.amazon.tests.TestBase;
import org.testng.annotations.Test;

public class PositiveTest extends TestBase {

    @Test
    public void loginTest1() {

        LoginPages loginPages = new LoginPages();

        extentLogger=report.createTest("Test1");
    loginPages.loginUser();
        System.out.println("1 = " + 1);
    }


    @Test
    public void loginTest2() {

        LoginPages loginPages = new LoginPages();

        extentLogger=report.createTest("Test2");
        loginPages.loginUser();
        System.out.println("2 = " + 2);
    }





}
