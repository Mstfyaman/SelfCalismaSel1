package com.amazon.test.day5_Css;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssWithMultipleAttributes {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.hepsiburada.com");

        WebElement searchBox = driver.findElement(By.cssSelector("input[class='desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b'][type='text']"));
        searchBox.sendKeys("Database");

        WebElement searchBTN = driver.findElement(By.cssSelector("div[class='SearchBoxOld-cHxjyU99nxdIaAbGyX7F']"));
        searchBTN.click();

        Thread.sleep(3000);
        driver.close();





        // KALIP ; CSS icin --------- > TagName[Attribute1=‘value1’] [Attribute2=‘value2’]

    }
}
