package com.amazon.tests.day8_WebElements2;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IsSelected_CheckBox {

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
        WebElement checkBox1 = driver.findElement(By.cssSelector("#gridCheck1"));

        System.out.println("checkBox.isSelected() = " + checkBox1.isSelected());
                //  locator ettiğimiz kutucuklar seçili mi? değil mi?
        Assert.assertFalse(checkBox1.isSelected(),"FAİL");


        Thread.sleep(2000);


        WebElement checkBox2 = driver.findElement(By.cssSelector("#gridCheck2"));

        System.out.println("checkBox2.isSelected() = " + checkBox2.isSelected());
                //  locator ettiğimiz kutucuklar seçili mi? değil mi?
        Assert.assertTrue(checkBox2.isSelected(),"FAİL");


        Thread.sleep(3000);
        checkBox1.click();  // işaretli olmayan checkbox 1 i tıkladık. ve aşağıda yeniden doğruladık

        Assert.assertTrue(checkBox1.isSelected(),"FAİL");
        Assert.assertTrue(checkBox2.isSelected(),"FAİL");

    }







}
