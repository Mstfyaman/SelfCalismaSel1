package com.amazon.tests.day8_WebElements2;

import org.testng.Assert;
import org.testng.annotations.*;

public class SummaryOfTestLastLesson {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite Runs");
    }
    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test Runs");
    }
    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class Runs");
    }
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method Runs");
    }



    @Test
    public void test1() {
        Assert.assertTrue(4>2);
        System.out.println("Test1");
    }
    @Test
    public void test2() {
        Assert.assertFalse(1>2);
        System.out.println("Test2");
    }
    @Test
    public void test3() {
        Assert.assertEquals(1,1);
        System.out.println("Test3");
    }



    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite Runs");
    }
    @AfterTest
    public void afterTest() {
        System.out.println("After Test Runs");
    }
    @AfterClass
    public void afterClass() {
        System.out.println("After Class Runs");
    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method Runs");
    }


}
