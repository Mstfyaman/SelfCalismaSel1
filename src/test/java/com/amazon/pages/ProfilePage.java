package com.amazon.pages;


import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {

    //  WebDriver driver;

    @FindBy(xpath = "//button[.='Edit Profile'] ")
    public WebElement editBtn;


    @FindBy(css = "#name")
    public WebElement fullName;

    @FindBy(css = "#about")
    public WebElement about;

    @FindBy(xpath = "(//input[@id='company'])[1]")
    public WebElement company;

    @FindBy(css = "#terms")
    public WebElement slider;

    @FindBy(css = ".form-select")
    public WebElement job;

    @FindBy(xpath = "//input[@id='website']")
    public WebElement website;

    @FindBy(xpath = "(//input[@id='location'])[1]")
    public WebElement location;

    @FindBy(xpath = "//input[@id='skills']")
    public WebElement skills;

    @FindBy(xpath = "//button[.='Save Changes']")
    public WebElement save;


    @FindBy(xpath = "//div[@class='alert alert-success bg-success text-light border-0 alert-dismissible fade show']")
    public WebElement profileUpdate;


    public void profileTabs(String tabName) {
        //  driver= Driver.get();
        String tablocator = "//button[.='" + tabName + "']";

        BrowserUtils.waitForClickablility(By.xpath(tablocator), 5);
        WebElement tabElement = driver.findElement(By.xpath(tablocator));
        tabElement.click();

    }


    @FindBy(xpath = "//input[@placeholder='Job Title *']")
    public WebElement jobTitle;

    @FindBy(xpath = "//input[@placeholder='Company *']")
    public WebElement companyexperience;

    @FindBy(xpath = "//input[@placeholder='Location']")
    public WebElement locationExperience;

    @FindBy(xpath = "(//input[@placeholder='From Date'])[1]")
    public WebElement startYear;

    @FindBy(xpath = "(//input[@placeholder='To Date '])[1]")
    public WebElement endYear;

    @FindBy(xpath = "//textarea[@placeholder='Job Description']")
    public WebElement jobDescription;

    @FindBy(xpath = "//button[@value='experience']")
    public WebElement addExperienceBtn;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement profilEmail_loc;

    //========================================

    @FindBy(css = "#school")
    public WebElement schoolOrBootcamp;

    @FindBy(css = "#degree")
    public WebElement degreeOrCertificate;

    @FindBy(css = "#study")
    public WebElement study;

    @FindBy(xpath = "(//input[@id='fromdate'])[2]")
    public WebElement fromDate;

    @FindBy(css = "#todateedu")
    public WebElement toDate;

    @FindBy(xpath = "(//textarea[@id='description'])[2]")
    public WebElement programDescription;

    @FindBy(xpath = "//button[@value=\"education\"]")
    public WebElement addEducation;

    @FindBy(xpath = "(//a[@class=\"btn btn-primary\"])[22]")
    public WebElement viewProfile;

    @FindBy(xpath = "//div[.='Robinson']")
    public WebElement fullNameRabinson;

    @FindBy(xpath = "//div[.='Developer']")
    public WebElement jobSdet;

    @FindBy(xpath = "//div[.='GHAN IT']")
    public WebElement companyGhanIt;

    @FindBy(xpath = "//span[.='Dashboard']")
    public WebElement dashboardOdev4;




}
