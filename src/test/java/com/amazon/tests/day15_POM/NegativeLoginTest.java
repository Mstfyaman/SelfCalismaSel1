package com.amazon.tests.day15_POM;

import com.amazon.pages.LoginPages;
import com.amazon.tests.TestBase;
import com.amazon.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    LoginPages loginPages = new LoginPages();

    @Test
    public void wrongPassword() throws InterruptedException {

        driver.get(ConfigurationReader.get("url"));

        //  LoginPages loginPages = new LoginPages();
        //  üstteki objeyi method dışında, class içinde tanımladık ve bütün methodlarda ortak kullanabiliriz.

        loginPages.userEmailInput_loc.sendKeys(ConfigurationReader.get("userEmail"));
        Thread.sleep(1000);
        loginPages.passwordInput_loc.sendKeys("somepassword");
        Thread.sleep(1000);
        loginPages.loginButton_loc.click();

//        WebElement usernameInput = driver.findElement(By.name("email"));
//        WebElement passwordInput = driver.findElement(By.name("password"));
//
//        usernameInput.sendKeys(ConfigurationReader.get("username"));
//        passwordInput.sendKeys("some password");
//
//        driver.findElement(By.xpath("//button[@class=\"btn btn-primary w-100\"]")).click();
//
//        WebElement warningMessage = driver.findElement(By.xpath
//                ("//*[contains(text(),'Email address or password is incorrect. Please check')]"));
//
//        Assert.assertEquals(warningMessage.getText(),
//                "Email address or password is incorrect. Please check",
//                "Verify that user is NOT login");
    }



    @Test
    public void wrongUserName() throws InterruptedException {

        driver.get(ConfigurationReader.get("url"));

        loginPages.userEmailInput_loc.sendKeys("someusername");
        Thread.sleep(1000);
        loginPages.passwordInput_loc.sendKeys(ConfigurationReader.get("password"));
        Thread.sleep(1000);
        loginPages.loginButton_loc.click();


        String exceptedMessage ="Email address or password is incorrect. Please check";
        Assert.assertEquals(loginPages.warningMessage_loc.getText(),exceptedMessage);

    }



}
