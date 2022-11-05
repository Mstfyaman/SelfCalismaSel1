package com.amazon.test.day7_TestNG;

import org.testng.annotations.*;

public class BeforeAfterMethod {

    @BeforeClass
    public void setUpClass() {
        System.out.println("---- Before Class ----");
    }

    @Test
    @Ignore                                          // @Ignore ile testi comment ettik.
    public void test1() {
        System.out.println("First Test First Test Case");
    }

    @Test
    public void test2() {
        System.out.println("Second Test Second Test Case");
    }

    //  @Test                                                 //  @Testin başına // koyunca comment e yarum a alır. ignorla aynı işlev
    public void comment() {
        System.out.println("Test Case Comment");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Before Method");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("After Method");
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("---- After Class ----");
    }


}
