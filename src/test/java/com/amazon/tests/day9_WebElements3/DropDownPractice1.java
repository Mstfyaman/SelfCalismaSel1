package com.amazon.tests.day9_WebElements3;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownPractice1 {

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

            /*
    1. go to http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html
    2. DropDowns Menusunden SQL,TestNG ve CSS sec

     */


        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");

        WebElement sql = driver.findElement(By.cssSelector("#dropdowm-menu-1"));

        Select sqlselect = new Select(sql);
        sqlselect.selectByValue("sql");


        Thread.sleep(2000);

        WebElement testNg = driver.findElement(By.cssSelector("#dropdowm-menu-2"));
        Select testNGSelect = new Select(testNg);
        testNGSelect.selectByIndex(2);

        Thread.sleep(2000);

        WebElement css = driver.findElement(By.cssSelector("#dropdowm-menu-3"));
        Select cssSelect = new Select(css);
        cssSelect.selectByVisibleText("CSS");








    }

}
