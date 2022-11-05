package com.amazon.test.day6_WebElements;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetAttribute {
    public static void main(String[] args) throws InterruptedException {

        // two ways to get text from web element
        // 1. getText() --> it will work %99 work and it will return string
        // 2. getAttribute("AttributeName") --> second way of getting text especially input box

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");

        Thread.sleep(1000);

        WebElement emailBox = driver.findElement(By.xpath("//input[@name='email']"));
        // emailBox.sendKeys(email);

        Thread.sleep(2000);

        String value= emailBox.getAttribute("class"); // class represent attribute name of email input box
            // yazdığımız class ın sitedeki texti =  form-control
        System.out.println("value = " + value);

        Thread.sleep(2000);
        driver.close();


    }
}
