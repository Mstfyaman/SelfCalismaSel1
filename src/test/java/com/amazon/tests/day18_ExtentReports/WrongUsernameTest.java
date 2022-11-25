package com.amazon.tests.day18_ExtentReports;

import com.amazon.pages.LoginPages;
import com.amazon.tests.TestBase;
import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WrongUsernameTest extends TestBase {

    @Test
    public void wrongUsername(){

        LoginPages loginPages = new LoginPages();

        extentLogger= report.createTest("Wrong Username Test"); // testin adı

        extentLogger.info("Enter wrong username");
        loginPages.userEmailInput_loc.sendKeys("wrong name");

        extentLogger.info("Enter corect password");
        loginPages.passwordInput_loc.sendKeys(ConfigurationReader.get("password"));

        extentLogger.info("Login button click");
        loginPages.loginButton_loc.click();

        String actualMessage= loginPages.warningMessage_loc.getText();

        extentLogger.info("Verify that NOT log in");
        Assert.assertEquals(actualMessage,"Email address or password is incorrect. Please check");

        extentLogger.info("PASSED");
    }

    @Test
    public void wrongPassword() {

        LoginPages loginPages = new LoginPages();

        extentLogger=report.createTest("Wrong Username Test");

        BrowserUtils.waitFor(1);

        extentLogger.info("Enter correct username");
        loginPages.userEmailInput_loc.sendKeys(ConfigurationReader.get("userEmail"));

        extentLogger.info("Enter wrong password");
        loginPages.passwordInput_loc.sendKeys("yanlisPass");

        extentLogger.info("Click login button");
        loginPages.loginButton_loc.click();

        String actualMessage = loginPages.warningMessage_loc.getText();

        extentLogger.info("Verify that NOT log in");
        // Assert.assertEquals(actualMessage,"Email address or password is incorrect. Please check");
        Assert.assertEquals(actualMessage,"AAAEmail address or password is incorrect. Please checkAAA");

        extentLogger.pass("PASSED");

    }
}
