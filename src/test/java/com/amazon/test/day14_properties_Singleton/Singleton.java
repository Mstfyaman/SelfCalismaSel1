package com.amazon.test.day14_properties_Singleton;

import org.testng.annotations.Test;

public class Singleton {

    // singleton class will have private constructor
    // it means other classes can NOT create an object of tihs class


    private Singleton() {
    }

    private static String str;



    public static String getInstance() {

        if (str==null){
            System.out.println("str is null, assignig a value to it");
            //str="some value";
            str="chrome";
        }else {
            System.out.println("it has a value, just returning it");
        }
        return str;
    }



}
