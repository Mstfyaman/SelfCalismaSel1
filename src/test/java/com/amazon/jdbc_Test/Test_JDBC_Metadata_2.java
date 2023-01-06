package com.amazon.jdbc_Test;

import java.sql.*;

public class Test_JDBC_Metadata_2 {
    public static void main(String[] args) {

        String url= "jdbc:sqlserver://94.73.170.25:1433;" +  // burası  ip ile portu içerir
                "DatabaseName=u0583688_Kraft2;" + // databasenin ismi
                "encrypt=true;" + // bunu şifreleyerek göndermeyi kabul ediyorum
                "trustServerCertificate=true;"; // database serverinin sertifikalı olduğuna güveniyorum

        String userName="u0583688_Kraft2";
        String password="ANKARA123456789*0987654fg";
        String query="SELECT TOP(10) * FROM u0583688_Kraft2.product.brand";


        try ( Connection  connection = DriverManager.getConnection(url,userName,password);
              Statement   statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
              ResultSet resultSet = statement.executeQuery(query);
        )
        {
            ResultSetMetaData metaData = resultSet.getMetaData();

            metaData.getColumnCount();
            System.out.println("metaData.getColumnCount() = " + metaData.getColumnCount());


            // Columncountu kullanarak ilk satırın değerlerini ekrana yazdıralım

//            int kolonSayısı = metaData.getColumnCount();
//            resultSet.next();
//            for (int i=1; i<= kolonSayısı; i++){
//                System.out.print(resultSet.getString(i)+" " );
//            }


            // Columncountu kullanarak bütün rowları alt alta yazdıralım

     //      int kolonSayısı = metaData.getColumnCount();
//            for (int i=1; i<= kolonSayısı; i++){
//                resultSet.next();
//                System.out.println(resultSet.getString(1)+" => "+resultSet.getString(2));
//            }

            //while ile yapımı
//            while (resultSet.next()){
//
//                for (int i=1; i<= kolonSayısı; i++){
//                    System.out.print(resultSet.getString(i)+" ");
//                 }
//                System.out.println("");
//            }



            // Tablomuzun kolon isimleriyle beraber yazdıralım

            int kolonSayısı = metaData.getColumnCount();
            for (int i=1; i<=kolonSayısı; i++){
                System.out.print(metaData.getColumnName(i)+" ");
            }
            System.out.println("");

            while (resultSet.next()){

                for (int i=1; i<= kolonSayısı; i++){
                    System.out.print(resultSet.getString(i)+"  "+"  "+"  "+"  ");
                 }
                System.out.println("");
            }






        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }
}
