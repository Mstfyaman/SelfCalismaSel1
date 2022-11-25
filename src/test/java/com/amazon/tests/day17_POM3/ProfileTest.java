package com.amazon.tests.day17_POM3;


import com.amazon.pages.DashboardPage;
import com.amazon.pages.LoginPages;
import com.amazon.pages.ProfilePage;
import com.amazon.tests.TestBase;
import com.amazon.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ProfileTest extends TestBase {


    LoginPages loginPages = new LoginPages();
    ProfilePage profilePage = new ProfilePage();
    DashboardPage dashboardPage = new DashboardPage();

    @Test
    public void editProfile(){

        loginPages.loginUser();
        dashboardPage.myProfile.click();

        BrowserUtils.waitFor(2);
        profilePage.profileTabs("Edit Profile");  // buraya tıkladı.

        profilePage.fullName.clear();
        profilePage.fullName.sendKeys("Rabinson");

        profilePage.about.clear();
        profilePage.about.sendKeys("Some worsd are here");

        profilePage.company.clear();
        profilePage.company.sendKeys("GHAN IT ");

        BrowserUtils.waitForPresenceOfElement(By.cssSelector("#terms"),5);
        BrowserUtils.dragAndDropBy(profilePage.slider,300,0);

        Select select= new Select(profilePage.job);
        select.selectByVisibleText("QA Engineer");

        profilePage.website.clear();
        profilePage.website.sendKeys("https://Krafttechnologie.com");

        profilePage.location.clear();
        profilePage.location.sendKeys("Istanbul");

        profilePage.skills.clear();
        profilePage.skills.sendKeys("Selenium,TestNG");

        // profilePage.save.click();  // buna gücü yetmedi js ile yaptık.
        BrowserUtils.clickWithJS(profilePage.save);

    }


    @Test
    public void aadExperience(){

        loginPages.loginUser();
        dashboardPage.myProfile.click();

        BrowserUtils.waitFor(2);
        profilePage.profileTabs("Add Experience");

        profilePage.jobTitle.clear();
        profilePage.jobTitle.sendKeys("Software Test Engineer");

        profilePage.companyexperience.clear();
        profilePage.companyexperience.sendKeys("GHAN IT");

        profilePage.locationExperience.clear();
        profilePage.locationExperience.sendKeys("Ankara");

        profilePage.startYear.clear();
        profilePage.startYear.sendKeys("25/07/2022");

        profilePage.endYear.clear();
        profilePage.endYear.sendKeys("25/03/2022");

        profilePage.jobDescription.clear();
        profilePage.jobDescription.sendKeys("Selenium,TestNG");

        profilePage.addExperienceBtn.click();





    }



}