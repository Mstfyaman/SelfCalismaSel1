package com.amazon.tests;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
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

    // extent report
   protected ExtentReports report;
   protected ExtentHtmlReporter htmlReporter;
   protected ExtentTest extentLogger;

   @BeforeTest
   public void setUpTest(){

       // initialize the class
       report =new ExtentReports();

       // create a report path
       String projecPath = System.getProperty("user.dir");  // projenin pathini alır.
       String reportPath= projecPath+ "/test-output/report.html";  // bu projenin ve raporun ismini verir.
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

    @AfterClass
    public void tearDown(ITestResult result) throws InterruptedException, IOException {

       // if test fails
        if (result.getStatus()==ITestResult.FAILURE){
            // Recod the name of failed test
            extentLogger.fail(result.getName());
            //Take the screenshot and return the location of screenshot
            String screenshotPath= BrowserUtils.getScreenshot(result.getName());
            // Add the screenshot to the report
            extentLogger.addScreenCaptureFromPath(screenshotPath);
            // Capture the exception and put inside the report
            extentLogger.fail(result.getThrowable());
        }


        Thread.sleep(3000);
        // driver.close();
        driver.quit();
    }



}