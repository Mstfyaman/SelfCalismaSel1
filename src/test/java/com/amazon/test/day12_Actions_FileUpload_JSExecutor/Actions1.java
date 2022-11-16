package com.amazon.test.day12_Actions_FileUpload_JSExecutor;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Actions1 {


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
    public void doubleClick() {

        // Action class ileri düzey etkileşimler sunar
        // doubleclick, draggAndDropp, hover, rightclick..vb
        // Action class Seleniumdan gelir. WebDriver constructo gibi parametre olarak atanır
        // Cunku driverin browserle etkileşime geçebilmesi için


        driver.get("https://webdriveruniversity.com/Actions/index.html");

        WebElement ciftTikYapilacakYer = driver.findElement(By.id("double-click"));

        Actions actions = new Actions(driver);
        actions.doubleClick(ciftTikYapilacakYer).perform();

    }

    @Test
    public void dragAndDrop() throws InterruptedException {

        driver.get("https://webdriveruniversity.com/Actions/index.html");

        WebElement dragText = driver.findElement(By.id("draggable"));
        WebElement dropText = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);

        Thread.sleep(2000);
        actions.dragAndDrop(dragText,dropText).perform();     // 1. yol
        // birincide göderilecek olan, ikincide teslim terini yazıyoruz


        actions.moveToElement(dragText).clickAndHold().moveToElement(dropText).release().perform(); // 2. yol
            // once sürüklencek elementi hold ettik. sonra dropText e sürükledik ve release ettik.

    }

    @Test
    public void DRAGaNDdROP2() throws InterruptedException {

        /*
     go to  https://www.krafttechexlab.com/javascript/droppable
     Drag Me to my target elementini Drop here elementinin uzerine surukle birak

     */

        driver.get("https://www.krafttechexlab.com/javascript/droppable");

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);

        Thread.sleep(2000);
        actions.dragAndDrop(source,target).perform();

        Thread.sleep(2000);
        String exceptedMsj = "Dropped!";
        String actualMsj = target.getText();

        Assert.assertEquals(actualMsj,exceptedMsj);

    }

    @Test
    public void hover() throws InterruptedException {

        driver.get("https://webdriveruniversity.com/Actions/index.html");

        WebElement hoverMe = driver.findElement(By.xpath("//button[.='Hover Over Me First!']"));
        WebElement link1= driver.findElement(By.xpath("(//a[.='Link 1'])[1]"));


        Actions actions = new Actions(driver);
        actions.moveToElement(hoverMe).perform();   // hover in üzerine geldi ve bekledi, link 1 göründü.

        Assert.assertTrue(link1.isDisplayed());  // link 1 göründü mü diye sorduk

        link1.click(); // link 1 e tıkladık ve accept ettik.

        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    @Test
    public void hover2() {

        /*
    go to  https://www.krafttechexlab.com/components/tooltips
    Tooltip on top elementine hover yap
    sonrasinda diger elementleri de tek tek hover yap
     */


        driver.get("https://www.krafttechexlab.com/components/tooltips");

        WebElement toolTipTop = driver.findElement(By.xpath("(//button[@type='button'])[1]"));

        Actions actions = new Actions(driver);

        actions.moveToElement(toolTipTop).perform();


        String excepted = "Tooltip on top";
        String actual = toolTipTop.getText();
        System.out.println("actual = " + actual);
         Assert.assertEquals(actual,excepted);


        List<WebElement> otherToolTip = driver.findElements(By.xpath("//button[@type='button']"));

        for (WebElement tool : otherToolTip){
            actions.moveToElement(tool).pause(2000).perform(); // burda pause de koyaliyoruz
            System.out.println("tool.getText() = " + tool.getText());
        }
    }


    @Test
    public void rightClick() throws InterruptedException {

        /*
     go to https://demoqa.com/buttons
     Right Click Me elementine sag click yap ve
     Assert et
     */

        driver.get("https://demoqa.com/buttons");

        WebElement rightClick =driver.findElement(By.id("rightClickBtn"));

        Actions actions = new Actions(driver);

        actions.contextClick(rightClick).perform();

        Thread.sleep(2000);

        WebElement message = driver.findElement(By.id("rightClickMessage"));

        String excepted ="You have done a right click";

        Assert.assertEquals(message.getText(),excepted);





    }




}
