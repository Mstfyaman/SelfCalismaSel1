package com.amazon.test.day9_WebElements3;

import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownWithNoSelect {

    WebDriver driver ;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {

        driver.get("https://demoqa.com/select-menu");

        // Dropdown kutusunu locate ediyoruz
        WebElement dropDownMenu = driver.findElement(By.xpath("(//div[@class=' css-1wa3eu0-placeholder'])[1]")) ;

        // kutudaki ilk elementi assert edelim
        String exceptedOption = "Select Option";
        String actualOption = dropDownMenu.getText();
        System.out.println("actualOption = " + actualOption);
        Assert.assertEquals(actualOption,exceptedOption,"FAIL");


        // Dropdown içerisinde Group 2 Option 1 seçeneğini çagıralım
        // Buradaki sorun inspect yapilmak istendiğinde menu gizleniyor
        // Bunu aşmak için Event Element menusündeki Blur altındaki öğeleri remove edelim


        dropDownMenu.click();
        WebElement group2Option1 = driver.findElement(By.cssSelector("#react-select-2-option-1-0"));
        Thread.sleep(2000);
        group2Option1.click();

        // Group 2 Option 1 seçildikten sonra verify etmek için tekrar locate ediyoruz

        Thread.sleep(1000);
        WebElement selectedOption = driver.findElement(By.xpath("//div[@class=' css-1uccc91-singleValue']"));
        System.out.println("selectedOption.getText() = " + selectedOption.getText());
        String exceptedOption2 ="Group 2, option 1";
        String actualOption2 = selectedOption.getText();
        Assert.assertEquals(exceptedOption2,actualOption2,"FAIL");




    }




}
