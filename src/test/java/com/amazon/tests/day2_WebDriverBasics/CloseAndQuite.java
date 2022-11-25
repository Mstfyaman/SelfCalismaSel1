package com.amazon.tests.day2_WebDriverBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuite {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.krafttechnologie.com");

        Thread.sleep(2000);
        driver.close(); // bu method la geçerli sekmeyi kapatırız. Yani açık olanı. Diger sekmeler açık kalır


        driver=new ChromeDriver();    // close işleminden sonra tekrar sayfaya gitmek için yeni bir browser oluşturmak gerekir.
        // go to "https://www.facebook.com" web adress
        driver.get("\"https://www.facebook.com\"");

        Thread.sleep(2000);
        driver.quit(); // bütün browser i kapatır.Hiç bir sekme kalmaz





    }
}
