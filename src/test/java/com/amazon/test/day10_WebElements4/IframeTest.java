package com.amazon.test.day10_WebElements4;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTest {

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
    public void iframe() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/iframe");


        // how to switch the frame
        // first way using NAME or ID
        driver.switchTo().frame("mce_0_ifr");  // id yi yazarak frame yi değiştir dedik

        WebElement textArea = driver.findElement(By.cssSelector("#tinymce"));
        textArea.clear(); // içerde yazılı olanları önce sildik
        Thread.sleep(2000);
        textArea.sendKeys("Batch 2 was here"); // sonra boş olan yere bunu yazdırdık


        // second way switch INDEX
        driver.switchTo().parentFrame();   // first we should go back to parent
        driver.switchTo().frame(0);
        textArea.clear();
        textArea.sendKeys("Batch 2 was here Two Times");


        driver.switchTo().parentFrame();
        // third way using WEB ELEMENT
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        textArea.clear();
        textArea.sendKeys("This is third way");

    }
}
