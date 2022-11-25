package com.amazon.tests.day4_Xpath;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathStarstWithAndContainsWith {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.hepsiburada.com");

       WebElement searchBox= driver.findElement(By.xpath("//input[starts-with(@class,'desktopOld')]"));
            // ..... ile başlayan
        searchBox.sendKeys("Selenium");

        WebElement searchHbtn= driver.findElement(By.xpath("//div[contains(@class,'SearchBoxOld-cH')]"));
                // arama butonu
        searchHbtn.click();








        // KALIP ; //TagName[starts-with(@Attribute,‘value’)]

    }
}
