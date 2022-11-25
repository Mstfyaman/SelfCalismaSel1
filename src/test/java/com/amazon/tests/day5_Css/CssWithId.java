package com.amazon.tests.day5_Css;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssWithId {
    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");

        WebElement searchBox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        searchBox.sendKeys("Css");

        WebElement searchButton = driver.findElement(By.cssSelector("#nav-search-submit-button"));
        searchButton.click();


        // KALIP ; Syntax: id icin # isareti kullanilir. Locate edreken # isareti konulup
        //value yazilir: #id


    }
}
