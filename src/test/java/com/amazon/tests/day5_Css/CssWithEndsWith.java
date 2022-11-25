package com.amazon.tests.day5_Css;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssWithEndsWith {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");

        WebElement searchBox = driver.findElement(By.cssSelector("input[id$='textbox']"));     // sonu ... ile biten dedik.
        searchBox.sendKeys("APİ");

        WebElement searchButton = driver.findElement(By.cssSelector("input[id$='button']"));  // sonu ... ile biten dedik
        searchButton.click();



        // KALIP ;  CSS icin --------- > TagName[Attribute$=‘value’]    starts-with ten farkı $ işaresi


    }
}
