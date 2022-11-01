package com.amazon.test.day3_Basic_Locators;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassNameTest {
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

        //------------------------yukarısı namalocator ve tagnamelocalr ile aynı-- aşağısı ClassName-------------

        System.out.println("driver.findElement(By.className(\"col-md-4\")).getText() = " + driver.findElement(By.className("col-md-4")).getText());


    }
}
