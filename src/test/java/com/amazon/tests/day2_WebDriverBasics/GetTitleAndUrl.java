package com.amazon.tests.day2_WebDriverBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {
    public static void main(String[] args) {

        // Task open chrome and navigate to https://www.kraftechnologie.com
        // get page title

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.krafttechnologie.com");
        System.out.println("driver.getTitle() = " + driver.getTitle());

        // getting the url from browser --> browserdan url alma
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        // get the source of page --> sayfanın kaynağını alma
        String pageSource=driver.getPageSource();
        System.out.println("pageSource = " + pageSource);


    }
}
