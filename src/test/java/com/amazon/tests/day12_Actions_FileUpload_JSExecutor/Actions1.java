package com.amazon.tests.day12_Actions_FileUpload_JSExecutor;

import com.amazon.utilities.WebDriverFactory;
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

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // 20 saniyelik bekleme süresi belirledik veyeteri kadar bekleyecek.
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        // driver.close();
        driver.quit();
    }

    @Test
    public void doubleClick() throws InterruptedException {

        // Action class ileri düzey etkileşimler sunar
        // doubleclick, dragganddropp, hover, rightclick .. vb
        // Action class Seleniumdan gelir. Webdriver constcutor gibi parametre olarak atanir
        // cunku driveri browserla etkileşime gecirebikmek için

        driver.get("https://webdriveruniversity.com/Actions/index.html");
        WebElement doubleclick = driver.findElement(By.cssSelector("#double-click"));

        Actions actions = new Actions(driver);  // çift double için obje oluşturduk.

        actions.doubleClick(doubleclick).perform();  // çift tıkmalası için böyle yapıyoruz. perform(); demek gerekiyor
        Thread.sleep(2000);

    }


    @Test
    public void dragAndDrop() {

        driver.get("https://webdriveruniversity.com/Actions/index.html");

        WebElement dragDrop = driver.findElement(By.cssSelector("#draggable"));  // sürüklenecek olan
        WebElement dropHere = driver.findElement(By.cssSelector("#droppable")); // sürüklenecek yer

        Actions actions = new Actions (driver);
        actions.dragAndDrop(dragDrop,dropHere).perform();
        // ilk once sürüklenecek olanı sonra sürüklenecek yeri yazıyoruz.

        //bunu clickAndHold() ve moveToElement() + release().perform();   ilede yapabiliriz
        // actions.moveToElement(dragable).clickAndHold().moveToElement(dropable).release().perform();  // böyle

    }


    @Test
    public void dragAndDrop2() {


        /*
     go to  https://www.krafttechexlab.com/javascript/droppable
     Drag Me to my target elementini Drop here elementinin uzerine surukle birak

     */


        driver.get("https://www.krafttechexlab.com/javascript/droppable");

        WebElement dragDrop = driver.findElement(By.cssSelector("#draggable"));
        WebElement dropHere = driver.findElement(By.cssSelector("#droppable"));

        Actions actions = new Actions (driver);
        actions.dragAndDrop(dragDrop,dropHere).perform();

        System.out.println("dropHere.getText() = " + dropHere.getText());
        String excep = "Dropped!";
        Assert.assertEquals(dropHere.getText(),excep);

    }

    @Test
    public void hover1() throws InterruptedException {

        driver.get("https://webdriveruniversity.com/Actions/index.html");

        WebElement hoverMe = driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        WebElement link1 =driver.findElement(By.xpath("(//a[.='Link 1'])[1]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(hoverMe).perform(); // mice yi hareket ettitir ancak tıklamaz.

        Assert.assertTrue(link1.isDisplayed());  // göründü mü?

        link1.click();

        Alert alert = driver.switchTo().alert();  // inspect i alınmayan alert için
        Thread.sleep(2000);

        String actualText= alert.getText();
        String expectedText = "Well done you clicked on the link!";
        Assert.assertEquals(actualText,expectedText);

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

        WebElement tooldtipOnTop= driver.findElement(By.xpath("(//button[@type='button'])[1]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(tooldtipOnTop).perform(); // mice yi hareket ettitir ancak tıklamaz.


        String actualText = tooldtipOnTop.getAttribute("data-bs-placement");
        System.out.println("actualText = " + actualText);
        String expectedText = "top";
        Assert.assertEquals(actualText,expectedText);

        List<WebElement> hovers = driver.findElements(By.xpath("//button[@type='button']"));

        for (WebElement hover :hovers){
            actions.moveToElement(hover).pause(2000).perform();
            System.out.println("hover = " + hover.getText());
        }
    }

    @Test
    public void rightClick(){

    /*
     go to https://demoqa.com/buttons
     Right Click Me elementine sag click yap ve
     Assert et
     */


        driver.get("https://demoqa.com/buttons");

        WebElement rightClick =driver.findElement(By.id("rightClickBtn"));

        Actions actions = new Actions(driver);
        actions.contextClick(rightClick).perform();  // mausun sağ tıkı ile tıklamak için

        WebElement message = driver.findElement(By.cssSelector("#rightClickMessage"));
        String expectedMsj ="You have done a right click";
        String actualMsj = message.getText();
        Assert.assertEquals(actualMsj,expectedMsj,"FAİL");

    }



















}
