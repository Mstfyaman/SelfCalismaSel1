package com.amazon.test.day9_WebElements3;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownWithSelect {

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

        driver.get("https://demoqa.com/select-menu");

        //  1.dropDown i diğer elementler gibi locate ediyoruz
        WebElement dropDownElement = driver.findElement(By.cssSelector("#oldSelectMenu"));

        // 2. Elementi constructor gibi atarayak selenium classındaki selectten bir obje oluşturuyoruz

        Select select = new Select(dropDownElement);

        // 3. seçilen ilk elementi test edelim ( red)

        String exceptedElement = "Red";
        String actualElement= select.getFirstSelectedOption().getText();
        System.out.println("actualElement = " + actualElement);
        Assert.assertEquals(actualElement,exceptedElement,"FAIL");

        // ==============================================================================

        // DropDown dan diğer optionları nasıl getiririz
        // 1. select visibleText kullanıcaz

        Thread.sleep(2000);
        select.selectByVisibleText("Black");
        exceptedElement = "Black";
        actualElement = select.getFirstSelectedOption().getText();
        System.out.println("actualElement = " + actualElement);
        Assert.assertEquals(actualElement,exceptedElement,"FAIL");

        //=================================================================================
        // 2. index kullanarak buluyoruz

        Thread.sleep(2000);
        select.selectByIndex(6);
        exceptedElement="White";
        actualElement = select.getFirstSelectedOption().getText();
        System.out.println("actualElement = " + actualElement);
        Assert.assertEquals(exceptedElement,actualElement,"FAIL");

        //================================================================================
        // 3. value ile buluyoruz

        Thread.sleep(2000);
        select.selectByValue("3");
        exceptedElement = "Yellow";
        actualElement = select.getFirstSelectedOption().getText();
        System.out.println("actualElement = " + actualElement);
        Assert.assertEquals(exceptedElement,actualElement,"FAIL");











    }





}
