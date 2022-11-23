package com.amazon.test.day16_POM1;

import com.amazon.pages.DashboardPage;
import com.amazon.pages.LoginPages;
import com.amazon.test.TestBase;
import com.amazon.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTests extends TestBase {

    LoginPages loginPages=new LoginPages();
    DashboardPage dashboardPage=new DashboardPage();

    @Test
    public void navigateToTabAndModule(){

        loginPages.loginUser();

       // dashboardPage.navigateToModule("Forms","Checkbox");   // burda forms tan checkbox u çağırdık
        dashboardPage.navigateToModule("Components","Charts"); // burda componentten chartsı çağırdık

        String actualsubTitle = dashboardPage.subTitle("Charts");

        Assert.assertEquals(actualsubTitle,"Charts");

        BrowserUtils.waitFor(3000);
    }

    @Test
    public void getUser(){
        loginPages.loginUser();
        String actualUser = dashboardPage.userNames("Jhon Nash");
        System.out.println("actualUser = " + actualUser);

        String exceptedUser="Jhon Nash";
        Assert.assertEquals(actualUser,exceptedUser);
    }

    @Test
    public void myProfile(){
        loginPages.loginUser();
        dashboardPage.myProfile.click();

        BrowserUtils.waitFor(3);
    }

    @Test
    public void aFmTitle(){
        loginPages.loginUser();
        System.out.println("dashboardPage.aFmTitle.getText() = " + dashboardPage.aFmTitle.getText());
    }

    @Test
    public void copyRight(){
        loginPages.loginUser();
        System.out.println("dashboardPage.copyright.getText() = " + dashboardPage.copyright.getText());
    }



}
