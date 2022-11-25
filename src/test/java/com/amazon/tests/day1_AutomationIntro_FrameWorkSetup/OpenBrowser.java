package com.amazon.tests.day1_AutomationIntro_FrameWorkSetup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {

    public static void main(String[] args) {

         /*
           1. pomxml e yüklediğimiz webDriver manager kutuphanesinden chrome u hazır hale getirmesini isteyeceğiz.
           2. WebDriver classından driver i hazır hale getirmesini isteyeceğiz.
           3. driver a testini yapacağımız web sitesine bizi götürmesini isteyeceğiz

     */


       //WebDriverManager.firefoxdriver().setup();    // burasıda firefox browser ile yapımı
       // WebDriver driver= new FirefoxDriver();



        WebDriverManager.chromedriver().setup();  // 1.   chromu hazır hale getirir.

        WebDriver driver = new ChromeDriver(); // 2.   driver i hazır hale getirir.

        driver.get("https://www.nttgame.com/knight/en");  // 3.
        driver.manage().window().maximize();  // bu sayfayı açtıktan sonra ekranı kaplayacak kadar büyüt.

        System.out.println("driver.getTitle() = " + driver.getTitle()); // gittiğimiz sitenin başlığını getirir.


        String expectedTitle ="NTT Game - New Servers";

        String actualTitle= driver.getTitle();


        if (actualTitle.equals(expectedTitle)){
            System.out.println("Alinan baslik dogrudur. TESTI GECTI");
        }else {
            System.out.println("Baslik beklendigi gibi degil. TESTI GECMEZ");
        }


    }
}
