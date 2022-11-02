package com.amazon.test.day4_Xpath;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XpathWithContains {

    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/");

        String text =driver.findElement(By.xpath("//li[contains(text(),'Users')]")).getText();
        // contains kullanarak aranan text in bir kısmını(user) yazdık ve aradık. gitti buldu // text = All Users Profile
        System.out.println("text = " + text);



        // KALIP ;   //TagName[contains(text(),‘exact text’)]
    }


}
