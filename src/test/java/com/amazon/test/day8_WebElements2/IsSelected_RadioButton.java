package com.amazon.test.day8_WebElements2;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IsSelected_RadioButton {

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

        driver.get("https://www.krafttechexlab.com/forms/radio");
        WebElement radioButton1 = driver.findElement(By.cssSelector("#gridRadios1"));
        System.out.println("radioButton1.isSelected() = " + radioButton1.isSelected());
        Assert.assertTrue(radioButton1.isSelected(),"FAİL");

            // Radio buttonlardan sadece birisinin seçilmesinie izin verilir.
            // bir diğerini tıkladığımıza diğeri default olarak tıklası kaldırılır.


        WebElement radioButton2 = driver.findElement(By.cssSelector("#gridRadios2"));
        System.out.println("radioButton2.isSelected() = " + radioButton2.isSelected());
        Assert.assertFalse(radioButton2.isSelected(),"FAİL");


        Thread.sleep(3000);

        radioButton2.click();
        Assert.assertFalse(radioButton1.isSelected(),"FAİL");
        Assert.assertTrue(radioButton2.isSelected(),"FAİL");

    }




}
