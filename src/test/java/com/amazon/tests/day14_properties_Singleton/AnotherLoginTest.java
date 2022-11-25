package com.amazon.tests.day14_properties_Singleton;

import com.amazon.tests.TestBase;
import com.amazon.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    driver.findElement(By.id("email")).sendKeys(ConfigurationReader.get("userEmail"));
    driver.findElement(By.id("yourPassword")).sendKeys(ConfigurationReader.get("password")+ Keys.ENTER);


    }



}
