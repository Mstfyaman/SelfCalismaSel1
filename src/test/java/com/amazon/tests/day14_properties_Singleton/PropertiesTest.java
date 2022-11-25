package com.amazon.tests.day14_properties_Singleton;

import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PropertiesTest {

    @Test
    public void testName(){

        String browser= ConfigurationReader.get("browser");
        System.out.println("browser = " + browser);
            //browser = chrome

        String url = ConfigurationReader.get("url");
        System.out.println("url = " + url);
            //url = https://www.krafttechexlab.com/login

    }

    @Test
    public void openBrowserUsingConfigurationReader() {

        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));

        driver.get(ConfigurationReader.get("url"));

        driver.findElement(By.id("email")).sendKeys(ConfigurationReader.get("userEmail"));

        driver.findElement(By.id("yourPassword")).sendKeys(ConfigurationReader
                .get("password") + Keys.ENTER);
    }





}
