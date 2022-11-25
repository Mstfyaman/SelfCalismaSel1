package com.amazon.tests.day14_properties_Singleton;

import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {

    @Test
    public void test1() {
        //Singleton singleton = new Singleton();

        // String s1= Singleton.getInstance();
        String driver1= Singleton.getInstance();

        // String s2= Singleton.getInstance();
        String driver2= Singleton.getInstance();

        // System.out.println(s1);
        System.out.println(driver1);

        //  System.out.println(s2);
        System.out.println(driver2);
    }

    @Test
    public void test2() {

       // WebDriver driver = WebDriverFactory.getDriver("chrome");

        WebDriver driver = Driver.get();

        driver.get(ConfigurationReader.get("url"));
    }

    @Test
    public void test3() throws InterruptedException {

        //  WebDriver driver = WebDriverFactory.getDriver("chrome");
        WebDriver driver= Driver.get();
        driver.get("https://www.krafttechexlab.com/login");
        Thread.sleep(2000);

    }

    @Test
    public void tes4() {

        //  WebDriver driver = WebDriverFactory.getDriver("chrome");
        WebDriver driver= Driver.get();
        driver.get("https://www.amazon.co.uk");

    }
}
