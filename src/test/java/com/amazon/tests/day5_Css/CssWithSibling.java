package com.amazon.tests.day5_Css;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssWithSibling {
    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com");
        driver.manage().window().maximize();

        WebElement modul = driver.findElement(By.cssSelector("li[class='nav-item']~li[class='nav-item'] :nth-of-type(1)"));

        modul.click();




        // KALIP ; TagName[attribute1=‘value1’]~ TagName[attribute2=‘value2’]    // ~  ~  ~
                // Syntax: takip eden kardes ile locate ederken ~ isareti kullanilir.
    }
}
