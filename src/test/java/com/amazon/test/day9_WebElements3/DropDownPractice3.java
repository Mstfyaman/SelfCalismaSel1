package com.amazon.test.day9_WebElements3;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownPractice3 {

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
    2. Radio Button  kutusundaki elementlerin sayisini bul ve tum elementleri yazdir
    3. Blue elementini sec
        */

        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");

        List < WebElement > radioButton = driver.findElements(By.xpath("//input[@name='color']"));
        System.out.println("radioButton.size() = " + radioButton.size());

        for (WebElement radio : radioButton) {
            System.out.println("radio.getAttribute(\"Value\") = " + radio.getAttribute("Value"));
        }

        WebElement blue = driver.findElement(By.xpath("//input[@value='blue']"));
        blue.click();


    }
}
