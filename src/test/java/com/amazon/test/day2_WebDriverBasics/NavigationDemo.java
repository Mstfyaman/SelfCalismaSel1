package com.amazon.test.day2_WebDriverBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {
    public static void main(String[] args) throws InterruptedException {

        // go to google --> google git
        // go to facebook --> facebook a git
        // back to google - google geri dön

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("www.google.com");

        Thread.sleep(3000);
        driver.navigate().to("www.facebook.com");

        Thread.sleep(3000);
        driver.navigate().back();







    }

}
