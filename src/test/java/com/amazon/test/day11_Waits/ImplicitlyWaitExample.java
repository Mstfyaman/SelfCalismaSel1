package com.amazon.test.day11_Waits;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitlyWaitExample {

    WebDriver driver ;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        // driver.close();
        driver.quit();
    }


    @Test
    public void test1() {

    driver.get("https://the-internet.herokuapp.com/dynamic_controls");
    driver.findElement(By.cssSelector("#checkbox-example>button")).click();

        WebElement message = driver.findElement(By.cssSelector("#message"));
        Assert.assertEquals(message.getText(),"It's gone!");

    }
}
