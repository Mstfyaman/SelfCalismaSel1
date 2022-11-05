package com.amazon.test.day6_WebElements;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatURLNotChanged {
    public static void main(String[] args) throws InterruptedException {

        /** Class Task
         *  open the chrome browser
         *  go to https://www.krafttechexlab.com/login
         *  click on login button
         *  verify that url did changed
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");

        String exceptedURL= driver.getCurrentUrl();
        System.out.println("exceptedURL = " + exceptedURL);

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

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
