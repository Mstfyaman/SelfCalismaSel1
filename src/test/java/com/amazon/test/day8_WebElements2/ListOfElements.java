package com.amazon.test.day8_WebElements2;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {


    WebDriver driver ;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {

        driver.get("https://www.krafttechexlab.com/javascript/clicks");

        List<WebElement> buttons =driver.findElements(By.xpath("//button[@class='btn btn-primary']"));
        System.out.println("button.size() = " + buttons.size());  // içerisinde kaç tane elaman var diye sorduk
        Assert.assertEquals(buttons.size(),4); // içerisinde 4 tane eleman var mı? diye doğruladık

        for (WebElement button : buttons){
            System.out.println("button.getText() = " + button.getText());  // burda list içindeki elemanları yazdırdık.
            System.out.println("button.isDisplayed() = " + button.isDisplayed()); // elementler var mı? yok mu?
        }

        Thread.sleep(2000);
        buttons.get(2).click(); // burda listteki 2. elemente tıkladık. indeksi istediğiz seçeriz


    }




}
