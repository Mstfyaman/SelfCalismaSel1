package com.amazon.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

        // Task
        // write a static method that takes a string parameter name : browserType
        // it will setup the browser
        // and the method will return chromedriver or firefoxdriver object
        // name of the method : getDriver


    public static WebDriver getDriver(String browserTyper){
        WebDriver driver = null;
        switch (browserTyper.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }

        return  driver;
    }





}
