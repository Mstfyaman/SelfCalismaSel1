package com.amazon.test.day14_properties_Singleton;

import com.amazon.test.TestBase;
import com.amazon.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AnotherLoginTest extends TestBase {

    //18.11.2022
    // Class Task
    // go to url
    //enter password
    // click login button



    @Test
    public void test1(){

        driver.get(ConfigurationReader.get("url"));
    driver.findElement(By.id("email")).sendKeys(ConfigurationReader.get("username"));
    driver.findElement(By.id("yourPassword")).sendKeys(ConfigurationReader.get("password")+ Keys.ENTER);


    }



}
