package com.amazon.test.day2_WebDriverBasics;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {
    public static void main(String[] args) throws InterruptedException {

        // burda utilities te ki WebDriverFactory i çağırdık. üzererine ayrıca ekleme olmuş olabilir.


        WebDriver driver = WebDriverFactory.getDriver("chrome");
       // driver.get("https://www.krafttechnologie.com");

       // Thread.sleep(3000);
      //  driver.close();

        //----------------------aşağıda da yukarıdaki methodu kullanrak yeni örnek çözdük-----
        /**
         * go to "https://www.krafttechexlab.com"  website
         * excepted title = Dasboard- Kraft Techex Lab - aFm
         * get title and verify that excepted title equal actual title
         */

        driver.get("https://www.krafttechexlab.com");
        String exceptedTitle ="Dasboard- Kraft Techex Lab - aFm";
        driver.getTitle();
        System.out.println("exceptedTitle = " + exceptedTitle);
        String actualTitle =driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);

        if (actualTitle==exceptedTitle){
            System.out.println("Eşleşme doğru.Testi GEÇTİ");
        }else if (actualTitle!=exceptedTitle){
            System.out.println("Eşleşme yanlış.Testi GEÇMEDİ");
        }




    }
}
