package com.amazon.tests.day9_WebElements3;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownPractice2 {

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

        /*
    1. go to http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html
    2. Checkboxes kutusundan sadece option 1  ve 4 u sec 3 seçili onu iptal et
    */


        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");

        List<WebElement> options = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for (WebElement box : options) {
            System.out.println("box.getAttribute(\"Value\") = " + box.getAttribute("Value"));
        }


        if (!options.get(0).isSelected()){
            options.get(0).click();
        }if (!options.get(3).isSelected()){
            options.get(3).click();
        }if (options.get(2).isSelected()){
            options.get(2).click();
        }

















    }
}
