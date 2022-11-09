package com.amazon.test.day8_WebElements2;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IsEnabled {



    WebDriver driver ;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.krafttechexlab.com/forms/checkbox");
        WebElement checkBox = driver.findElement(By.cssSelector("#gridCheck3"));  // burası 1. örnek

        System.out.println("checkBox.isEnabled() = " + checkBox.isEnabled());
                    // lacator ettiğimiz yer kullanmak için etkin mi? kullanılar bilir mi?

        Assert.assertFalse(checkBox.isEnabled(),"FAIL");

        Thread.sleep(2000);

        WebElement checkBox2 = driver.findElement(By.cssSelector("#gridCheck2"));  // burası 2. örnek
        System.out.println("checkBox2.isEnabled() = " + checkBox2.isEnabled());
                  // lacator ettiğimiz yer kullanmak için etkin mi? kullanılar bilir mi?

        Assert.assertTrue(checkBox2.isEnabled(),"FAIL");

    }




}
