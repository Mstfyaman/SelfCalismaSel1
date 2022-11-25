package com.amazon.tests.day6_WebElements;

import com.amazon.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrowserStackTask {
    public static void main(String[] args) throws InterruptedException {

        /** Class Task
         *  go to the url -  "https://www.browserstack.com/users/sign_up"
         *  maximize the window
         *  accept cookies if any ,
         *  fill in the blanks with the faker class
         *  click "Term of service" checkbox
         *  and close the window
         *
         *  hint: u can use any locator you want
         *
         */

        Faker faker= new Faker();

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.browserstack.com/users/sign_up");
        driver.manage().window().maximize();

        Thread.sleep(2000);
        WebElement cookies = driver.findElement(By.cssSelector("#accept-cookie-notification"));
        cookies.click();

        WebElement fullName = driver.findElement(By.cssSelector("#user_full_name"));
        fullName.sendKeys(faker.name().firstName());

        WebElement email = driver.findElement(By.id("user_email_login"));
        email.sendKeys(faker.internet().emailAddress());

        WebElement password = driver.findElement(By.cssSelector("input[type^='pass']"));
        password.sendKeys(faker.internet().password());

        Thread.sleep(2000);
        WebElement checkBox = driver.findElement(By.xpath("/html/body/main/div[5]/section/form/div[1]/div/div[1]/div[8]/div/div/input"));
        checkBox.click();

        Thread.sleep(1000);
        WebElement singMeUp = driver.findElement(By.cssSelector("input[value*='Si']"));
        singMeUp.click();




        Thread.sleep(2000);
        driver.close();






    }
}
