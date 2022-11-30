package com.amazon.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import com.amazon.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    // Extent Report
    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest extentLogger;

    @BeforeTest
    public void setUpTest(){

        // initialize the class
        report =new ExtentReports();

        //create a report path
        String projectPath = System.getProperty("user.dir");  // projenin pathini alır **
        String reportPath = projectPath+ "/test-output/report.html";
//     String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());   // çoklu almak istersek burası ve alt satırı aç-üstü kapat
//     String reportPath=projectPath + "/test-output/report"+date+".html";

        // initialize the html report with the reportPath
        htmlReporter = new ExtentHtmlReporter(reportPath);

        // attach the html to the report object
        report.attachReporter(htmlReporter);

        // title in report
        htmlReporter.config().setReportName("KraftTechB2 Smoke Test");

        // set environment
        report.setSystemInfo("Environment","Production");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));  // ?
        report.setSystemInfo("OS", System.getProperty("os.name")); // windosw mu? ios mu? sistemi gösterir.
        report.setSystemInfo("Test Engineer", "Mustafa");
    }

    @AfterTest
    public void tearDownTest(){
        report.flush();
    }


    @BeforeMethod
    public void setUp() {

        driver = Driver.get();
        driver.get(ConfigurationReader.get("url"));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(Driver.get(),15);
        actions = new Actions(driver);

        driver.manage().window().maximize();

    }


    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException, IOException {
        //If Test Fails
        if (result.getStatus()==ITestResult.FAILURE){

            //Record the name of failed test
            extentLogger.fail(result.getName());
            //Take the screenshot and return the location of screenshot
            String screenShotPath= BrowserUtils.getScreenshot(result.getName());
            //Add the screenshot to the report
            extentLogger.addScreenCaptureFromPath(screenShotPath);
            //Capture the exception and put inside the report
            extentLogger.fail(result.getThrowable());

        }

        Thread.sleep(2000);
        //  driver.close();
        Driver.closeDriver();

    }




}