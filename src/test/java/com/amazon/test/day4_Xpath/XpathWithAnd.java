package com.amazon.test.day4_Xpath;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathWithAnd {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.hepsiburada.com");

        // WebElement searchBox= driver.findElement(By.xpath(
        //       "//input[@type='text' and @class='desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b']"));

        WebElement searchBox= driver.findElement(By.xpath(
                "//input[@type='dsadastext' or @class='desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b']"));
        // and yerine or yazdık, o değilse o olur mu gibi.... bir kısmını bozduk

        searchBox.sendKeys("JAVA");


        // AND İÇİN KALIP ;  //TagName[@attribute1=‘value1’] [@attribute2=‘value2’]
                    //TagName[@attribute1=‘value1’ and @attribute2=‘value2’     and kullanacaksak içteki [] ler kalkar


        // OR İÇİN KALIP ; //TagName[@attribute1=‘value1’ or @attribute2=‘value2’]


    }
}
