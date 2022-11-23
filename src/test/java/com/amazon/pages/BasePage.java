package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public  BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    public void navigateToModule(String tab, String module){

        String tabLocator= "//span[.='"+tab+"']";
        String moduleLocator= "//span[.='"+module+"']";

        BrowserUtils.waitForPresenceOfElement(By.xpath(tabLocator),5);
        WebElement tabElement= Driver.get().findElement(By.xpath(tabLocator));
        tabElement.click();

        BrowserUtils.waitForClickablility(By.xpath(moduleLocator),5);
        Driver.get().findElement(By.xpath(moduleLocator)).click();
    }

    public String subTitle(String subTitle){
        String subTitleLocator= "//h1[.='"+subTitle+"']";

        BrowserUtils.waitForPresenceOfElement(By.xpath(subTitleLocator),5);

        WebElement SubTitle= Driver.get().findElement(By.xpath(subTitleLocator));

        String actualSubTitle = SubTitle.getText();
        return actualSubTitle;
    }



}
