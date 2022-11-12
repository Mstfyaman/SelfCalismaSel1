package com.amazon.test.day11_Waits;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExpilicitlyWaitExample {

    WebDriver driver ;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        // driver.close();
        driver.quit();
    }

    @Test
    public void test1() {

    driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

    driver.findElement(By.cssSelector("#start>button")).click();

    //**** How to wait explicitly ****
        // Create an explicitly object wait

        WebDriverWait wait = new WebDriverWait(driver,15); //

        WebElement hello = driver.findElement(By.xpath("//h4[.='Hello World!']"));
        // it will wait up to 15 seconds until hello element is visible
        wait.until(ExpectedConditions.visibilityOf(hello));

        Assert.assertEquals(hello.getText(),"Hello World!");

    }

    @Test
    public void test2() {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[.='Enable']")).click();

      //  driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("Batch 2 was here");
        // böyle yapınca görmedi, wait objeci oluşturacağız


        WebDriverWait wait = new WebDriverWait(driver,10);

        WebElement inputBox = driver.findElement(By.xpath("//input[@type=\"text\"]"));

        wait.until(ExpectedConditions.elementToBeClickable(inputBox));

        inputBox.sendKeys("Batch two was here");

        WebElement message = driver.findElement(By.xpath("//p[@id=\"message\"]"));
        String actual = "It's enabled!";

        Assert.assertEquals(message.getText(),actual);


    }



}
