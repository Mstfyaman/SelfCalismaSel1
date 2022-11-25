package com.amazon.tests.day2_WebDriverBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {
    public static void main(String[] args) throws InterruptedException {

        // go to google --> google git
        // go to facebook --> facebook a git
        // back to google - google geri dön

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(); // poly
        driver.navigate().to("https://www.google.com");

        Thread.sleep(3000);
        driver.navigate().to("https://www.facebook.com");  //navigate to diğer bir selenium methodu

        Thread.sleep(3000);
        driver.navigate().back();  // sayfaya geri dönüş için

        Thread.sleep(3000);
        driver.navigate().forward();   // sayfayı tekrar ileri götürür

        Thread.sleep(3000);
        driver.navigate().refresh(); // sayfayı yenileme yapar



    }

}
