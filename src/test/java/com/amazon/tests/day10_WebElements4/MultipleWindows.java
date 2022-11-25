package com.amazon.tests.day10_WebElements4;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {

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
    public void twoWindows() {

        driver.get("https://the-internet.herokuapp.com/windows");
        System.out.println("titleBeforeClick = " + driver.getTitle());

        WebElement clickHere = driver.findElement(By.linkText("Click Here"));
        clickHere.click();

     //   String titleAfterClick = driver.getTitle();
     //   System.out.println("titleAfterClick = " + titleAfterClick);


        // yeni pencere açıldıktan sonra selenium eski sayfada kaldı, yeni sayfaya geçmedi
        // yeni sayfaya geçmesi için bizden talimat istiyor

        String currentTab = driver.getWindowHandle(); // title the internet and has ID --> currentTab = CDwindow-7E50589988BC6A7F801A74235AACDAD0
        System.out.println("currentTab = " + currentTab);


        Set<String> windowHandles = driver.getWindowHandles(); // çok pencerelerin ID lerini tutar

        for (String tab : windowHandles) {  // go and check one by one
            if (! tab.equals(currentTab)){
                driver.switchTo().window(tab);
            }
        }
        System.out.println("driver.getTitle() = " + driver.getTitle());
    }


    @Test
    public void multipleWindows() {

        driver.get("https://the-internet.herokuapp.com/windows");

        System.out.println("driver.getTitle() = " + driver.getTitle());

        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());

        WebElement clickHere = driver.findElement(By.linkText("Click Here"));
        clickHere.click();
        clickHere.click();   // 3. pencereyi açarsak
        clickHere.click();  // 4. percereyi açarsak  ----> yani çoklu pencere açıyoruz

        Set<String> windowHandles = driver.getWindowHandles();

        for (String tab : windowHandles) {
            driver.switchTo().window(tab);  // tablar arası geçiş sağlar
            if (driver.getTitle().equals("New Window")){  // hangisine gideceğimizi belirler ve 75. satırdaki setten alır.
                // stop on this now
                break;
            }
        }

        System.out.println(" after click = " + driver.getTitle());


    }





}
