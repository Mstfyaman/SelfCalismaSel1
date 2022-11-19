package com.amazon.pages;

import com.amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPages {

    public LoginPages(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(name = "email")
    public WebElement userNameInput_loc;

    @FindBy(name = "password")
    public WebElement passwordInput_loc;

    @FindBy(xpath = "//button[@class=\"btn btn-primary w-100\"]")
    public WebElement loginButton_loc;

    @FindBy(xpath = "//*[contains(text(),'Email address or password is incorrect. Please check')]")
    public WebElement warningMessage_loc;




}
