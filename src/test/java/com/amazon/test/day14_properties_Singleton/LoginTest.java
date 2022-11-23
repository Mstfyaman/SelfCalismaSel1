package com.amazon.test.day14_properties_Singleton;

import com.amazon.pages.DashboardPage;
import com.amazon.pages.LoginPages;
import com.amazon.test.TestBase;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    LoginPages loginPages=new LoginPages();
    DashboardPage dashboardPage=new DashboardPage();

    @Test
    public void openBrowserUsingConfigurationReader() {


        driver.get(ConfigurationReader.get("url"));

        driver.findElement(By.id("email")).sendKeys(ConfigurationReader.get("username"));

        driver.findElement(By.id("yourPassword")).sendKeys(ConfigurationReader
                .get("password") + Keys.ENTER);

    }

    @Test
    public void loginWithMethod(){

        loginPages.loginUser();

        String actualTitle= dashboardPage.DashboardPageTitle("Dastboard");
        System.out.println("actualTitle = " + actualTitle);

        String exceptedTitle= "Dashboard";
        Assert.assertEquals(actualTitle,exceptedTitle);

    }



}
