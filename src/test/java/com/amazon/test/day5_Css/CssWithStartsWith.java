package com.amazon.test.day5_Css;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssWithStartsWith {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");

        WebElement searchBox = driver.findElement(By.cssSelector("input[id^='twotab']"));
        searchBox.sendKeys("Cucumber SoftWare");

        WebElement searchButton = driver.findElement(By.cssSelector("input[type^='subm']"));
        searchButton.click();



         // KALIP;   CSS icin --------- > TagName[Attribute^=‘value’]    value nin başlangıcını


    }
}
