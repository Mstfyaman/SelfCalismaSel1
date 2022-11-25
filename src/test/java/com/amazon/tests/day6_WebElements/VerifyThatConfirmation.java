package com.amazon.tests.day6_WebElements;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatConfirmation {
    public static void main(String[] args) throws InterruptedException {


        /** Class TAsk 3
         *          open chrome browser
         *          go to https://www.krafttechexlab.com/login
         *         enter email as mike@gmail.com
         *         enter password as 12345
         *         click login btn
         *         verify that home page is "Dashboard"
         */

        String email ="mike@gmail.com";
        String password ="12345";

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");

        WebElement emailBox = driver.findElement(By.xpath("//input[@name='email']"));
        emailBox.sendKeys(email);

        WebElement passwordBox = driver.findElement(By.xpath("//input[@type='password']"));
        passwordBox.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        String expectedHomeText ="Dashboard";
        String accualHomeText= driver.findElement(By.tagName("h1")).getText();

        Thread.sleep(2000);

        if (accualHomeText.equals(expectedHomeText)){
            System.out.println("SAME");
        }else {
            System.out.println("DIFFERENT");
        }




    }
}
