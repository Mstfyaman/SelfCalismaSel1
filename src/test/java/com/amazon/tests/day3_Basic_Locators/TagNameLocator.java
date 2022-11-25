package com.amazon.tests.day3_Basic_Locators;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TagNameLocator {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");

        Thread.sleep(2000);

        WebElement emailInputBox = driver.findElement(By.name("email"));   // obje oluşturduk
        emailInputBox.sendKeys("mike@gmail.com");

        WebElement passwordInputBox = driver.findElement(By.name("password"));  // 1. yol kısa yolu altta.
        passwordInputBox.sendKeys("12345");

        driver.findElement(By.cssSelector(".btn.btn-primary.w-100")).click();  // kısa yolu- layz way

        Thread.sleep(2000);


        // verify that you are on the dashport page  ------------   Burdan sonrası tagName ile ilgili. Yukjarısı nameLocator ile aynı

        System.out.println("driver.findElement(By.tagName(\"h1\")).getText() = " + driver.findElement(By.tagName("h1")).getText());


        driver.get("https://the-internet.herokuapp.com/inputs");  // farklı siteye ait olanı yapıyoruz
        System.out.println("driver.findElement(By.tagName(\"h3\")).getText() = " + driver.findElement(By.tagName("h3")).getText());
        System.out.println("driver.findElement(By.tagName(\"p\")).getText() = " + driver.findElement(By.tagName("p")).getText());


        driver.close();




    }
}
