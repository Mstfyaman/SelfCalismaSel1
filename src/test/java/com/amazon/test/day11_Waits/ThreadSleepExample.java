package com.amazon.test.day11_Waits;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ThreadSleepExample {

    WebDriver driver ;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        // driver.close();
        driver.quit();
    }

    @Test
    public void test1() {

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("#start>button")).click();


        WebElement hello = driver.findElement(By.cssSelector("#finish>h4"));
        System.out.println("hello.getText() = " + hello.getText());


        // NİÇİN THREAD.SLEEP KULLANMAYALIM !!!!

        // 1. java kaynaklı bir wait metodudur
        // 2. süreci milisaniye olarak durdurur
        // 3. belirlenen zaman kadar durdurur( hepsini beklemek zorundayız)
        // 4. uzun veya kısaa olmamasına dikkat edilmelidir
        // NOT RECOMENDDED
        // 5. kullanılması durumunda minimum tercih edilmeli
        // 6. Thread.Sleeo testin koşturulmasını oldukça yavaşlatıyor

    }
}
