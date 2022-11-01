package com.amazon.test.day3_Basic_Locators;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkTextAndPartialLinkText {
    public static void main(String[] args) throws InterruptedException {

        //------------------LinkText-----------------

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");

        WebElement example1=driver.findElement(By.linkText("Example 1: Element on page that is hidden"));
        example1.click();   // exxample1 in linkine yönlerndircek ve tıklıyacak

        String expectedText="Example 1: Element on page that is hidden";
        String accualText=driver.findElement(By.tagName("h4")).getText();

        if (accualText.contains(expectedText)){
            System.out.println("PASS");
        }else {
            System.out.println("FAİLED");
        }

        Thread.sleep(2000);

        //---------------------PartialText--------------------------

        driver.navigate().back();

      // driver.findElement(By.partialLinkText("Example 2")).click();
       driver.findElement(By.partialLinkText("fact")).click();   // sondan ve baştan kabul ediyor

        String exceptedText2="Example 2: Element rendered after the fact";
        String accualText2= driver.findElement(By.tagName("h4")).getText();

        if (accualText2.contains(exceptedText2)){
            System.out.println("PASS2");
        }else {
            System.out.println("FAILED2");
        }







        Thread.sleep(2000);
        driver.close();


    }
}
