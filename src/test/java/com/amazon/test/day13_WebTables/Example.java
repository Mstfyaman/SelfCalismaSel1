package com.amazon.test.day13_WebTables;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Example {

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
    public void example () {

        driver.get("https://demoqa.com/webtables");

        WebElement element = driver.findElement(By.xpath("//div[@class=\"rt-table\"]"));
        System.out.println("element.getText() = " + element.getText());


    }

    @Test
    public void basliklar () {

        driver.get("https://demoqa.com/webtables");

        WebElement heads = driver.findElement(By.xpath("(//div[@class=\"rt-table\"]//div)[1]"));
        System.out.println("heads.getText() = " + heads.getText());
        // heads.getText() = First Name
        //Last Name
        //Age
        //Email
        //Salary
        //Department
        //Action
    }

    // //div[@class="rt-tr -even"]/..

    @Test
    public void example424 () {

        driver.get("https://demoqa.com/webtables");

        WebElement element = driver.findElement(By.xpath("//div[@class=\"rt-tr -even\"]/../../.."));
        System.out.println("element.getText() = " + element.getText());


    }



}
