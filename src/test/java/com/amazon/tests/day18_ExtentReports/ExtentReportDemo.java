package com.amazon.tests.day18_ExtentReports;

import com.amazon.utilities.ConfigurationReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentReportDemo {

    // tihs class is used for starting and building reports
    ExtentReports report;

    //this class is used to create HTML report file // bizim için file oluşturur
    ExtentHtmlReporter htmlReporter;

    //this class define a test, enable adding logs, author and test steps
    ExtentTest extentLogger;

    @BeforeMethod
    public void setUp(){

        // initialize the class
        report =new ExtentReports();

        // create a report path
        String projecPath = System.getProperty("user.dir");  // projenin pathini alır.
        String reportPath= projecPath+ "/test-output/report.html";  // bu projenin ve raporun ismini verir.

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

    @Test
    public void test1() {

        // give a name to the current test
        extentLogger=report.createTest("TC001 Login Test");

        // Test steps
        extentLogger.info("Open The Browser");
        extentLogger.info("Go To Url https://www.krafttechexlab.com/login");
        extentLogger.info("Enter username");
        extentLogger.info("Enter password");
        extentLogger.info("Click Login Button");
        extentLogger.info("Verify logged In");
        extentLogger.info("TC001 Login Test Is Passed");
    }


    @AfterMethod
    // this is when the repor is actualy created
    public void tearDown() {
        report.flush();
    }
}
