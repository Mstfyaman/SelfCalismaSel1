package com.amazon.jdbc_Test;

import java.sql.*;

public class Test_JDBC_Metadata {
    public static void main(String[] args) {

        String url= "jdbc:sqlserver://94.73.170.25:1433;" +  // burası  ip ile portu içerir
                "DatabaseName=u0583688_Kraft2;" + // databasenin ismi
                "encrypt=true;" + // bunu şifreleyerek göndermeyi kabul ediyorum
                "trustServerCertificate=true;"; // database serverinin sertifikalı olduğuna güveniyorum

        String userName="u0583688_Kraft2";
        String password="ANKARA123456789*0987654fg";
        String query="SELECT TOP(10) * FROM u0583688_Kraft2.product.product";

        try {
            Connection connection = DriverManager.getConnection(url,userName,password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            ResultSetMetaData metaData = resultSet.getMetaData();
            System.out.println("Kolon Sayısı = " + metaData.getColumnCount());
            // Kolon Sayısı = 6

            System.out.println("Kolon isimleri : 1. "+ metaData.getColumnName(1) +" |  2. " + metaData.getColumnName(2));
            // Kolon isimleri : 1. product_id |  2. product_name


            int kolonSayısı = metaData.getColumnCount();
            for (int i=1; i<=kolonSayısı; i++){
                System.out.println(i+ " => " +metaData.getColumnName(i));
            }
            // çıktı =
            // 1 => product_id
            //2 => product_name
            //3 => brand_id
            //4 => category_id
            //5 => model_year
            //6 => list_price






        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
