package com.amazon.test.day4_Xpath;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RelativeXpath {
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.hepsiburada.com/");

        String text=driver.findElement(By.xpath("(//a[@href='https://www.hepsiburada.com/cozummerkezi'])[1]")).getText();
            // normalde : "//a[@href='https://www.hepsiburada.com/cozummerkezi']" böyle. dış parantezler ve [1] yok.
                    // böyle yaparak; mesela 10 tane bu texten var biz [1]. ciyi istemiş oluyoruz.
        System.out.println("text = " + text);

        // Relative xpath cift slah (//) ile baslar ve sayfanin herhangi bir yerine
        //bakmayi ifade eder


    }
}
