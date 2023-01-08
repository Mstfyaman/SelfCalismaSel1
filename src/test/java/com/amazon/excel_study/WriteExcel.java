package com.amazon.excel_study;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class WriteExcel {



    public void writeExcel(String sheetName, int cellValue, int row, int column) throws IOException {

        String excelPath = "C:/Users/User/Desktop/writeExcel.xlsx";
        File file = new File(excelPath); // exceli çözümler

        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        XSSFSheet sheet = workbook.getSheet(sheetName);
        sheet.getRow(row).createCell(column).setCellValue(cellValue);

        FileOutputStream fileOutputStream = new FileOutputStream(new File(excelPath));

        workbook.write(fileOutputStream);
        workbook.close();
        fileOutputStream.close();

    }




}
