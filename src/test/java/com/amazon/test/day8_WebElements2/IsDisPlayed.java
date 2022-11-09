package com.amazon.test.day8_WebElements2;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IsDisPlayed {

    WebDriver driver ;

    @BeforeMethod
    public void setUp(){
       driver = WebDriverFactory.getDriver("chrome");
       driver.manage().window().maximize();
    }


    @Test
    public void test() {
        driver.get("https://demoqa.com/automation-practice-form");
       WebElement inputBox= driver.findElement(By.id("firstName"));

        System.out.println("inputBox.isDisplayed() = " + inputBox.isDisplayed());
                // aldığımız locator web sayfasında görünüyor mu?

        // verify inputBox is displayed or not
        Assert.assertTrue(inputBox.isDisplayed(),"verify is FAILED");

    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }


}
