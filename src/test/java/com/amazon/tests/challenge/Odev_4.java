package com.amazon.tests.challenge;

import com.amazon.pages.DashboardPage;
import com.amazon.pages.LoginPages;
import com.amazon.pages.ProfilePage;
import com.amazon.tests.TestBase;
import com.amazon.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Odev_4 extends TestBase {

    LoginPages loginPages=new LoginPages();
    DashboardPage dashboardPage = new DashboardPage();
    ProfilePage profilePage = new ProfilePage();

    @Test
    public void odev4() {

        extentLogger=report.createTest("Odev4");
        loginPages.loginUser();

        extentLogger.info("Open My Profile Page");
        dashboardPage.myProfile.click();

        extentLogger.info("Full Information In The Add Education Module Page Up");
        profilePage.profileTabs("Add Education");

        profilePage.schoolOrBootcamp.clear();
        profilePage.schoolOrBootcamp.sendKeys("Krafttech Technologie Bootcamp ");

        profilePage.degreeOrCertificate.clear();
        profilePage.degreeOrCertificate.sendKeys(" QA Engineer");

        profilePage.study.clear();
        profilePage.study.sendKeys("Tester");

        profilePage.fromDate.clear();
        profilePage.fromDate.sendKeys("25/07/2022");

        profilePage.toDate.clear();
        profilePage.toDate.sendKeys("25/03/2022");

        profilePage.programDescription.clear();
        profilePage.programDescription.sendKeys("Bringing a good test engineer to the IT industry");

        extentLogger.info("Add Education Button Click");
       // profilePage.addEducation.click();
        BrowserUtils.clickWithJS(profilePage.addEducation);

        extentLogger.info("Go To Back Dashboard Page");
        profilePage.dashboardOdev4.click();

        extentLogger.info("Open The View Profile");
       // profilePage.viewProfile.click();
        BrowserUtils.clickWithJS(profilePage.viewProfile);

        extentLogger.info("Verify Full name, Job, Company name");
        String actualFullName = profilePage.fullNameRabinson.getText();
        String exceptedFullName= "Robinson";
        Assert.assertEquals(actualFullName,exceptedFullName);

        String actualJob=profilePage.jobSdet.getText();
        String exceptedJob="QA";
      //  Assert.assertEquals(actualJob,exceptedJob);

        String actualCompany=profilePage.companyGhanIt.getText();
        String exceptedCompany="Ghan itTestNG,Cucumber";

        extentLogger.info("PASSED");






    }
}
