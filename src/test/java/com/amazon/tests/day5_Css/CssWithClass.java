package com.amazon.tests.day5_Css;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssWithClass {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");

        WebElement searchBox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        searchBox.sendKeys("TestNg");

        WebElement searchButton = driver.findElement(By.cssSelector(".nav-search-submit-text.nav-sprite.nav-progressive-attribute"));
        searchButton.click();


        // KALIP ;  Syntax: class icin . isareti kullanilir. Locate edreken . isareti konulup
        //value yazilir: .className     class name den önce nokta koyuyoruz.



    }
}
