package com.amazon.tests.day20_DataDrivenFrameWork;

import com.amazon.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilPractice {

    @Test
    public void readExcelFile(){

         /*
          ExcelUtiil den bir object oluşturacağız
          Obje ik tane parametre(argument) alacak
          Bunlar; dosyanın pathi ile çalışma yaptığımız sayfanın adı olacak
            */

        ExcelUtil qaTeam3= new ExcelUtil("src/test/resources/LoginList.xlsx", "QaTeam3");
        // loginList excel dosyasının path i ile dosya içindeki QaTeam3 sayfasının(sheet) adını yazdık.

        // önce satır (dataList) sayısını bulalım
        System.out.println("qaTeam3.rowCount() = " + qaTeam3.rowCount()); // qaTeam3.rowCount() = 10

        // Sayfadaki colum( sütün ) sayısını bulalım
        System.out.println("qaTeam3.columnCount() = " + qaTeam3.columnCount());  // qaTeam3.columnCount() = 3

        // Columların isimlerini alalım
        System.out.println("qaTeam3.getColumnsNames() = " + qaTeam3.getColumnsNames());
        // qaTeam3.getColumnsNames() = [Your Email, Password, Your Name]


        //Şimdi de qaTeam3 object atanan datayol liste olarak çağıralım
        List<Map<String, String>> dataList = qaTeam3.getDataList();
        //  System.out.println("dataList = " + dataList);

        for(Map<String,String> row:qaTeam3.getDataList()) {
            System.out.println("row = " + row);
        }
        // ÇIKTI;
//        row = {Your Email=rosa@test.com, Your Name=Rosa, Password=Test123456}
//        row = {Your Email=Ramanzi@test.com, Your Name=Mansimmo, Password=Test123456}
//        row = {Your Email=jhon@test.com, Your Name=Jhon Nash, Password=Test123456}
//        row = {Your Email=user11@test.com, Your Name=User11, Password=Test123456}
//        ......


        // 2 satırı getirelim
        System.out.println("dataList.get(2) = " + dataList.get(2));
        // dataList.get(2) = {Your Email=jhon@test.com, Your Name=Jhon Nash, Password=Test123456}

        // 2. satırın your name keyini istedik
        System.out.println("dataList.get(2).get(\"Your Name\") = " + dataList.get(2).get("Your Name"));
        // dataList.get(2).get("Your Name") = Jhon Nash
        // çağırmak istediğimiz key i yazarız. email se onu, password se onu


        // objemizdeki dataları array içine atalım ( burda sütün ve satırlar olduğu için 2 boyutlu array kullanılır)
        String [][] dataArray = qaTeam3.getDataArray();
        System.out.println(Arrays.deepToString(dataArray));  // deepToString ile yazdırmamız gerekiyor. gücü yetmez .)



    }


}
