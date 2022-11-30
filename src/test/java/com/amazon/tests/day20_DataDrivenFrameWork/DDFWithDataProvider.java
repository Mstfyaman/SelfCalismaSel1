package com.amazon.tests.day20_DataDrivenFrameWork;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Array;

public class DDFWithDataProvider {

    // önce @dataProvider dan metodumuzu oluşturuyoruz
    // bu method bizim testimize data sağlayacak

    @DataProvider(name = "AracSatısOranları")
    public Object[][] testData(){

        String[][] data= {

                {"Audi", "100","80","65","55"},
                {"Honda", "112","127","135","60"},
                {"Tesla", "20","30","25","15"},
                {"Mazda", "70","50","65","75"},
                {"Porche", "40","43","22","17"},
                {"Toyota", "100","100","165","155"},
                {"Volvo", "66","33","22","77"},
                {"Mercedes", "73","80","65","65"},

        };
        return data;
    }

    @Test(dataProvider = "AracSatısOranları")  // bu testin üstekini tanıması için ya yandaki gibi üstteki methodun ismini yazarak ya da üstteki metoda sonradan veridğimiz ismi yaraka tanımlatıyoruz.
    public void test(String aracMarkasi, String Ocak, String Subat,String Mart,String Nisan) {

        System.out.println(" Arac Markasi :"+aracMarkasi+ " : "+Ocak+" ,"+Subat+" ,"+Mart+" ,"+Nisan+"");


        // Arac Markasi :Audi : 100 ,80 ,65 ,55
        // Arac Markasi :Honda : 112 ,127 ,135 ,60
        // Arac Markasi :Tesla : 20 ,30 ,25 ,15
        // Arac Markasi :Mazda : 70 ,50 ,65 ,75
        // Arac Markasi :Porche : 40 ,43 ,22 ,17
        // Arac Markasi :Toyota : 100 ,100 ,165 ,155
        // Arac Markasi :Volvo : 66 ,33 ,22 ,77
        // Arac Markasi :Mercedes : 73 ,80 ,65 ,65



    }

}
