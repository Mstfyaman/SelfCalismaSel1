package com.amazon.excel_study;

import java.io.IOException;

public class ExcelMain {

    WriteExcel writeExcel = new WriteExcel();

    public static void main(String[] args) throws IOException {



      //  writeExcel.writeExcel("Sheet1","Mustafa",1,1);

       // carpımTablosu();
        carpımTablosuExcel();
    }



    public static void carpımTablosu(){

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(i * j+"\t");
            }
            System.out.println();

        }
    }




        public static void carpımTablosuExcel() throws IOException {

            WriteExcel writeExcel = new WriteExcel();

            for (int i = 1; i <= 10; i++) {
                for (int j = 1; j <= 10; j++) {
              //      String s = Integer.toString(i * j);
                    writeExcel.writeExcel("Sheet1",i*j,i,j);
                }

            }

    }









}





