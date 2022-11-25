package com.amazon.tests.day6_WebElements;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatURLChanged {
    public static void main(String[] args) throws InterruptedException {


/**
 *         open chrome browser
 *          go to https://www.krafttechexlab.com/login
 *         enter email as mike@gmail.com
 *         enter password as 12345
 *         click login btn
 *         verify that Url has changed
 */

        String email ="mike@gmail.com";
        String password ="12345";

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");

        String exceptedURL= driver.getCurrentUrl();
        System.out.println("exceptedURL = " + exceptedURL);
        Thread.sleep(1000);

        WebElement emailBox = driver.findElement(By.xpath("//input[@name='email']"));
        emailBox.sendKeys(email);

        WebElement passwordBox = driver.findElement(By.xpath("//input[@type='password']"));
        passwordBox.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        Thread.sleep(2000);

        String actualURL= driver.getCurrentUrl();
        System.out.println("actualURL = " + actualURL);

        Thread.sleep(2000);

        if (actualURL.equals(exceptedURL)){
            System.out.println("URL SAME");
        }else {
            System.out.println("URL DIFFERENT");
        }


        Thread.sleep(2000);
        driver.close();





    }
}
