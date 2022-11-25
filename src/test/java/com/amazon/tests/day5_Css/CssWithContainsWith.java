package com.amazon.tests.day5_Css;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssWithContainsWith {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");

        WebElement searchBox = driver.findElement(By.cssSelector("input[id*='tabsearch']"));  // ..... yı içeriyor mu?
        searchBox.sendKeys("Postman");

        WebElement searchButton = driver.findElement(By.cssSelector("input[id*='submit']"));  // ..... yı içeriyor mu?
        searchButton.click();






        // KALIP ;  CSS icin --------- > TagName[Attribute*=‘value’]   diğerlerinden farkı *

    }
}
