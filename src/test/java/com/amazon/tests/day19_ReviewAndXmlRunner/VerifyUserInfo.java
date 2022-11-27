package com.amazon.tests.day19_ReviewAndXmlRunner;

import com.amazon.pages.DashboardPage;
import com.amazon.pages.LoginPages;
import com.amazon.pages.ProfilePage;
import com.amazon.tests.TestBase;
import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyUserInfo extends TestBase {

    @Test
    public void task1() {

        /** Class Task
         * go to https://www.krafttechexlab.com/login web site
         * Login as a user
         * Verify that login is successful with account name
         * Click on My profile
         * Click on Edit Profile
         * Verify that email value
         * navigate back
         * Verify that Dashboard page with url
         *
         */

        LoginPages loginPages= new LoginPages();
        ProfilePage profilePage=new ProfilePage();
        DashboardPage dashboardPage= new DashboardPage();

        extentLogger=report.createTest("Task1");

        extentLogger.info("go to https://www.krafttechexlab.com/login web site");

        extentLogger.info("Login as a user");
        loginPages.userEmailInput_loc.sendKeys(ConfigurationReader.get("userEmail"));
        loginPages.passwordInput_loc.sendKeys(ConfigurationReader.get("password"));
        loginPages.loginButton_loc.click();

        BrowserUtils.waitFor(1);

        extentLogger.info("Verify that login is successful with account name");
        WebElement robinson = driver.findElement(By.xpath("//span[.='Rabinson']"));

        String actualUsername= robinson.getText();
        System.out.println("actualUsername = " + actualUsername);
        String exceptedUsername ="Rabinson";
        Assert.assertEquals(actualUsername,exceptedUsername);

        extentLogger.info("Click on My profile");
        dashboardPage.myProfile.click();

        extentLogger.info("Click on Edit Profile");
        profilePage.profileTabs("Edit Profile");

        extentLogger.info("Verify that email value");
        WebElement emailVerify = driver.findElement(By.xpath("//input[@id='email']"));
        String actualEmail= emailVerify.getAttribute("value");
        System.out.println("actualEmail = " + actualEmail);
        String exceptedEmail ="mike@gmail.com";
        BrowserUtils.waitFor(2);
        Assert.assertEquals(actualEmail,exceptedEmail);

        extentLogger.info("navigate back");
        driver.navigate().back();

        extentLogger.info("Verify that Dashboard page with url");
        String title = driver.getCurrentUrl();
        String actualTitle= title;
        System.out.println("actualTitle = " + actualTitle);
        String exceptedTitle ="https://www.krafttechexlab.com/index";
        Assert.assertEquals(actualTitle,exceptedTitle);

        extentLogger.info("PASSED");
    }

    @Test
    public void userInfo() {  // bu test üstteki benim yaptığım Task1 testinin Fatih hocanın yaptığı hali.
        LoginPages loginPages=new LoginPages();
        DashboardPage dashboardPage=new DashboardPage();
        ProfilePage profilePage=new ProfilePage();

        extentLogger=report.createTest("User Info Verification ");

        extentLogger.info("Login as a user");
        loginPages.loginUser();

        String expectedAccountName="Rabinson";
        extentLogger.info("Verify that login is successful and account name is " +
                expectedAccountName);
        String actualAccountName=loginPages.getAccountName_mtd(expectedAccountName);
        System.out.println("actualAccountName = " + actualAccountName);
        Assert.assertEquals(actualAccountName,expectedAccountName);

        extentLogger.info("Click on My profile");
        //loginPages.navigateToModule("My Profile","");
        dashboardPage.myProfile.click();

        String profileTab="Edit Profile";
        extentLogger.info("Click on Edit Profile");
        profilePage.profileTabs(profileTab);

        String expectedEmail="mike@gmail.com";
        extentLogger.info("Verify that email values is " + expectedEmail);
        Assert.assertEquals(profilePage.profilEmail_loc
                .getAttribute("value"),expectedEmail);

        extentLogger.info("Navigate back");
        driver.navigate().back();

        extentLogger.info("Verify that Dashboard page with url");
        Assert.assertEquals(driver.getCurrentUrl()
                ,"https://www.krafttechexlab.com/index");

        extentLogger.info("PASSED");

    }



}
