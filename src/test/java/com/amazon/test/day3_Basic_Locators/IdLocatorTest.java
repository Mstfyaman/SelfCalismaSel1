package com.amazon.test.day3_Basic_Locators;

import com.amazon.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IdLocatorTest {
    public static void main(String[] args) throws InterruptedException {


        Faker faker =new Faker();  // fake isim vs. oluşturacak bir obje oluşturuduk



        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/text-box");

       // driver.manage().window().maximize();   // full ekran yapar

        WebElement inputUserName= driver.findElement(By.id("userName"));
       // inputUserName.sendKeys("Kareta");
        inputUserName.sendKeys(faker.name().firstName());  // burası sahte oluşturur, üsteki bizim yazdığımız

        Thread.sleep(2000);

        WebElement inputEmail= driver.findElement(By.id("userEmail"));
       // inputEmail.sendKeys("blabla@gmail.com");
        inputEmail.sendKeys(faker.internet().emailAddress()); // burası sahte oluşturur üstü bizim yazdığımız





        Thread.sleep(2000);
        driver.close();



    }
}
