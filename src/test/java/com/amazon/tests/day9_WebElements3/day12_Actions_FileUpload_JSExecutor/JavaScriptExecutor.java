package com.amazon.tests.day9_WebElements3.day12_Actions_FileUpload_JSExecutor;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class JavaScriptExecutor {

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
    public void clickWithJS() throws InterruptedException {

        // Selenium ile çözemediğimiz bazı sorunlarda javascript executer kullanarak çözebiliriz
        // Bu sorunlar neler olabilir? : clicking, sendkeys, scroll down or scroll up
        // javscriptexecutor bir interface olduğu için new kullanarak yeni bir obje oluşturuyoruz
        // bu nedenle driver i casting yaparak kullanıyoruz

        driver.get("https://the-internet.herokuapp.com/floating_menu");

        WebElement elementalSelenium = driver.findElement(By.linkText("Elemental Selenium"));


        JavascriptExecutor js = (JavascriptExecutor) driver;  // bur da casting var
        Thread.sleep(2000);

        js.executeScript("arguments[0].scrollIntoView(true);"+"arguments[0].click()",elementalSelenium);
        Thread.sleep(2000);

        System.out.println("Title = " + js.executeScript("return document.title;").toString());
        // başlık almak için

        System.out.println("URL = " + js.executeScript("return document.URL;").toString());
        // URL almak için

        String currentWindowHandle = driver.getWindowHandle();
        Set<String> setWindowHandles = driver.getWindowHandles();

        for (String tab :setWindowHandles){

            if (!tab.equals(currentWindowHandle)){
                driver.switchTo().window(tab);
                System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
            }
        }

        String excepted = "http://elementalselenium.com/";
        String actual = driver.getCurrentUrl();
        Assert.assertEquals(actual,excepted);
    }

    @Test
    public void inputFirstNameAndLastName() {  // locate edilemeyen inputta veri girme

         /*
   go to  https://selectorshub.com/xpath-practice-page/
   Enter Last name kutusuna soyisim yazdir
     */


        driver.get("https://selectorshub.com/xpath-practice-page/");

        // executeScript("arguments[0].setAttribute('value', 'text')", WebElement);

        WebElement firtName= driver.findElement(By.xpath("//input[@placeholder=\"First Enter name\"]"));

        WebElement lastName= driver.findElement(By.xpath("//input[@placeholder=\"Enter Last name\"]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].setAttribute('value' , 'Hayri Hür')" ,firtName);
        js.executeScript("arguments[0].setAttribute('value' , 'YASAMİS')" ,lastName);
           // elle girilen isim yerine string name vb. yanımlayarak ta girebiliriz.
           // ÖRN ; js.executeScript("arguments[0].setAttribute('value', '"+name+"')", firstName);


        //  KALIP ;  js.executeScript("arguments[0].setAttribute('value', 'text')", WebElement);
    }


    @Test
    public void clickWithJS_3() throws InterruptedException {   // sayfayı aşağı indirme yukarı çıkarma


        driver.get("https://www.krafttechnologie.com/");

        // executeScript("window.scrollBy(0,3000)");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,3000)");  // sayfayı aşağıya indirdik

        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,-3000)");// sayfayı yukarı çkardık fark -(minus) sadece
        //  rakamlar değişe bilir azalma ve artma oranları sayfanın ortasına az yukarısına vb. gelebilir.

    }

}
