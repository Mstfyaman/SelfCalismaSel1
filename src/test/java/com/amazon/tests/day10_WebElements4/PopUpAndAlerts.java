package com.amazon.tests.day10_WebElements4;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopUpAndAlerts {

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
    public void popUp() throws InterruptedException {

        driver.get("http://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=7dd53");


        WebElement confirmDialog = driver.findElement(By.xpath("(//span[text()='Confirm'])[1]"));
        confirmDialog.click();

        WebElement yes= driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[4]"));
        yes.click();

        Thread.sleep(2000);

        // verify that confirm is accepted
        String exceptedMessage = "You have accepted";
        WebElement actualMessage = driver.findElement(By.xpath("//p[text()='You have accepted']"));

        //   actualMessage WebElement olduğundan sonuna getText() koyduk. String yaptık
        Assert.assertEquals(actualMessage.getText(),exceptedMessage,"FAIL");

    }


    @Test
    public void jsAlerts() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(1000);

        // click - Click For JS Alerts
        WebElement clickForJsAlerts = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        clickForJsAlerts.click();


        // inspect i olmayan alerte e geçmesi için obje oluşturduk.
        // e.g:1 switch to JS alert pop up
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        // click ok
        alert.accept();  // açılan butonu onaylaması için


        //e.g:2 click - Click For JS Confirm
        WebElement clickForJsConfirm = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        clickForJsConfirm.click();
        Thread.sleep(2000);
        alert.dismiss(); // reddettik

        //e.g:3 click -Click For Js Pompt
        WebElement clikForJsPompt = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        clikForJsPompt.click();
        Thread.sleep(2000);
        // send keys to JS prompt
        alert.sendKeys("Kraft Batch 2 was here");
        Thread.sleep(4000);
        System.out.println("alert.getText() = " + alert.getText());   // çıktı ;  alert.getText() = I am a JS prompt
        alert.accept();


        // Task : verify all result above JS Alerts

        WebElement result =driver.findElement(By.cssSelector("#result"));
        System.out.println("result.getText() = " + result.getText());



    }









}
