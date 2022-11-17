package com.amazon.test.day13_WebTables;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTables {

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
    public void printTable() {   // sitedeki tabloyu yazdırma - lacatede parentten locate etmek gerekiyor.

        driver.get("https://webdriveruniversity.com/Data-Table/index.html");

        WebElement table = driver.findElement(By.xpath("//table[@class=\"table table-light traversal-table\"]"));

        System.out.println("table.getText() = " + table.getText());

        //table.getText() = # First Last          tablonun tamamı bu.    3 tane başlık vs...
        //1 Andy Otto
        //2 Jacob Jones
        //3 Larry Scott
    }

    @Test
    public void tablonunBaşlıkları(){


        driver.get("https://webdriveruniversity.com/Data-Table/index.html");

        WebElement tableTitle = driver.findElement(By.xpath("//table[@class=\"table table-light traversal-table\"] /thead"));
                    // parentte gittik. (  /thead  )

        System.out.println("tableTitle.getText() = " + tableTitle.getText());

        // tableTitle.getText() = # First Last    tabloya ait 3 başlığıda aldık
    }

    @Test
    public void printTableSize() {    // başlıkların sayısnı (size) aldık

        // th tag indeki elementlerin size ni alalım
        // önce list içerisine atacağız

        driver.get("https://webdriveruniversity.com/Data-Table/index.html");

        List<WebElement> tableSize=driver.findElements(By.xpath("//table[@class=\"table table-light traversal-table\"]//th"));
            // tag a geldik  (  //th )

        System.out.println("tableSize.size() = " + tableSize.size());
        // tableSize.size() = 6


        // rows ( satirları ) size in bulalım
        List<WebElement> rwSize = driver.findElements(By.xpath("//table[@class=\"table table-light traversal-table\"] //tr"));
            //  satir sayısı ( //tr )
        System.out.println("rwSize.size() = " + rwSize.size());
          // rwSize.size() = 4


        // Headers ( basliklar ) haric rows ( satirların ) size ni blularım
        List<WebElement> allRowsWithOutHeaders = driver.findElements(By.xpath("//table[@class=\"table table-light traversal-table\"] //tbody//tr"));
                // başlık hariç satir sayısı ( //tbody//tr )
        System.out.println("allRowsWithOutHeaders.size() = " + allRowsWithOutHeaders.size());
        // allRowsWithOutHeaders.size() = 3

    }


    @Test
    public void getRow(){

        driver.get("https://webdriveruniversity.com/Data-Table/index.html");

           // sadece bir satırı almak istedik
        WebElement row2 = driver.findElement(By.xpath("//table[@class=\"table table-light traversal-table\"] //tbody//tr[2]"));
               // ( //tbody//tr[2]   )

        System.out.println("row2.getText() = " + row2.getText());
        // row2.getText() = 2 Jacob Jones
    }

    @Test
    public void getAllRows() throws InterruptedException {  // bütün satırları dinamik olarak alma

        driver.get("https://webdriveruniversity.com/Data-Table/index.html");

        List <WebElement> allRows= driver.findElements(By.xpath("//table[@class=\"table table-light traversal-table\"] //tbody//tr"));

        Thread.sleep(2000);

        for (int i =1; i<=allRows.size(); i++ ){
     WebElement row= driver.findElement(By.xpath("//table[@class=\"table table-light traversal-table\"] //tbody//tr["+i+"]"));
            // ( dinamik hale getirmek için ( //tbody//tr["+i+"] )

            System.out.println("row.getText() = " + row.getText());
        }
        //row.getText() = 1 Andy Otto
        //row.getText() = 2 Jacob Jones
        //row.getText() = 3 Larry Scott

    }

    @Test
    public void getAllCellsOneRow() {

        driver.get("https://webdriveruniversity.com/Data-Table/index.html");

       // List <WebElement> allCels= driver.findElements(By.xpath("//table[@class=\"table table-light traversal-table\"] //tbody//tr[2]/td"));
        WebElement jacop= driver.findElement(By.xpath("//table[@class=\"table table-light traversal-table\"] //tbody//tr[2]/td"));

        System.out.println("jacop.getText() = " + jacop.getText());
           // jacop.getText() = Jacob

//        for (WebElement element: allCels){
//            System.out.println("element.getText() = " + element.getText());
//        }



    }




}
