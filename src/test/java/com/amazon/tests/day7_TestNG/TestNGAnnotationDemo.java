package com.amazon.tests.day7_TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotationDemo {

    @BeforeMethod
    public void setUP() {
        System.out.println("Open Browser");
    }

    @Test
    public void test1() {
        System.out.println("First Test First Assertion");
        Assert.assertEquals("title","title");   // burdaki 1. de hata varsa testi bitirir. 2. ye geçmez

        System.out.println("First Test Second Assertion");     // hata 2.de başlarsa, 1. çalışır ve 2. çalışmaz
        Assert.assertEquals("url","url");
    }

    @Test
    public void test2() {        // bu testin kendisinde hata olursa yukarıdaki test1 çalışır ama bu çalışmaz
                                // eger yukarıdaki test1 de hata olurda burdaki test2 de hata olmazsa test1 çaışmaz test2 çalışır.
        System.out.println("Second Test Assertion");
        Assert.assertEquals("test2", "test2");
    }



    @AfterMethod
    public void tearDown() {
        System.out.println("Close Browser");
    }




}
