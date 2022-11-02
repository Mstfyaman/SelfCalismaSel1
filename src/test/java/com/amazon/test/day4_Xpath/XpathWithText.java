package com.amazon.test.day4_Xpath;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XpathWithText {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/");

        // String text = driver.findElement(By.xpath("//li[text()='All Users Profile']")).getText();
        // String text = driver.findElement(By.xpath("//li[.='All Users Profile']")).getText();
             // bu da text() yerine sadece . konmuş hali.
        String text = driver.findElement(By.xpath("//*[text()='All Users Profile']")).getText();
             // bu da li yerine(yani tagname yerine) * koyarak yapılır.  * = bütün html yi tara ve texti (all user profile) olanı bul getir demek
        System.out.println("text = " + text);



        // KALIP ; //TagName[text( )=‘tam metin’] veya //TagName[.=‘tam metin’]



    }

}
