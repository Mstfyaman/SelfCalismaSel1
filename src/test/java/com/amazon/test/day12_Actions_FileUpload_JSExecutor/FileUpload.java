package com.amazon.test.day12_Actions_FileUpload_JSExecutor;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FileUpload {

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
    public void upLoadFile() {

        // choose file elementi locate ediyoruz
        // sonrasinda sendKeys(file Path)
        // File Path
        // Windows için : shift tuşu + dosya üzerinde sağ click yapip copy asPath seçiyoruz
        // Mac için : sağ click option key + Copy... as PathNamc ( yol adi olarak kopyala )


        driver.get("https://demoqa.com/upload-download");

        WebElement fileUp = driver.findElement(By.id("uploadFile"));

        fileUp.sendKeys("C:\\Users\\User\\Desktop\\çıktı.docx");

        WebElement msjPath = driver.findElement(By.id("uploadedFilePath"));

        String exceptedMsj = "C:\\fakepath\\çıktı.docx";
        Assert.assertEquals(msjPath.getText(),exceptedMsj);

    }






}
