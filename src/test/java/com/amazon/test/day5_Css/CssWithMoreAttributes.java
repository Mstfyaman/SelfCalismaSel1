package com.amazon.test.day5_Css;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssWithMoreAttributes {
    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com");

        WebElement componentText = driver.findElement(By.cssSelector("div[class='row']>div[class='col-md-4']"));
        System.out.println("componentText.getText() = " + componentText.getText());




        // KALIP ;  CSS icin ------- > TagName[Attribute1=‘value1’] > TagName [Attribute2=‘value2’]
                // Syntax: yalnizca child elemente gitmek icin kulanilir(sadece bir seviye asagiya
        //gider). Parent xpath in sonuna > isareti konularak kullanilir.

    }
}
