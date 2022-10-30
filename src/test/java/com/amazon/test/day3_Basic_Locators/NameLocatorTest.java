package com.amazon.test.day3_Basic_Locators;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameLocatorTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");

        Thread.sleep(2000);

        WebElement emailInputBox = driver.findElement(By.name("email"));   // obje oluşturduk
        emailInputBox.sendKeys("mike@gmail.com");

        WebElement passwordInputBox = driver.findElement(By.name("password"));  // 1. yol kısa yolu altta.
        passwordInputBox.sendKeys("12345");

      //  driver.findElement(By.name("password")).sendKeys("12345");  // 2. yol kısa yol hepsi için

        Thread.sleep(2000);

       // WebElement buttonInputBox = driver.findElement(By.cssSelector(".btn.btn-primary.w-100"));  // login e basar.
      //  buttonInputBox.click();
        driver.findElement(By.cssSelector(".btn.btn-primary.w-100")).click();  // kısa yolu- layz way


    }
}
