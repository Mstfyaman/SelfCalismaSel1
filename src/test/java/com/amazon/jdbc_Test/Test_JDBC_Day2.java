package com.amazon.jdbc_Test;

import java.sql.*;

public class Test_JDBC_Day2 {
    public static void main(String[] args) {

        String url= "jdbc:sqlserver://94.73.170.25:1433;" +  // burası  ip ile portu içerir
                "DatabaseName=u0583688_Kraft2;" + // databasenin ismi
                "encrypt=true;" + // bunu şifreleyerek göndermeyi kabul ediyorum
                "trustServerCertificate=true;"; // database serverinin sertifikalı olduğuna güveniyorum

        String userName="u0583688_Kraft2";
        String password="ANKARA123456789*0987654fg";
        String query="SELECT TOP(10) * FROM u0583688_Kraft2.product.brand";

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,userName,password);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("COnnection occured");

            resultSet.close();
            statement.close();
            connection.close();






          //  resultSet.next();

         /*   System.out.println("resultSet.getString(2) = " + resultSet.getString(2));
            resultSet.next(); // 2 kere yazarak 2. row a gelmiş olduk
            System.out.println("resultSet.getString(2) = " + resultSet.getString(2));
            resultSet.previous(); // önceki row a geçtik
            System.out.println("resultSet.getString(2) = " + resultSet.getString(2));
            resultSet.last(); // burda en sona gittik.
            System.out.println("resultSet.getString(2) = " + resultSet.getString(2));
        //    resultSet.next(); // yukarıdaki last tan dolayı en sondaydık, bu sebepten bir ilerisi olmadığından exception verir.
            System.out.println("resultSet.getString(2) = " + resultSet.getString(2));
            resultSet.first(); // birinciye gittik
            System.out.println("resultSet.getString(2) = " + resultSet.getString(2));
        //  resultSet.beforeFirst(); // yukarıdaki firstten dolayı 1. sıradaydık. 1. sınanın bir öncesi olmadığından exception verir
            System.out.println("resultSet.getString(2) = " + resultSet.getString(2));
            resultSet.absolute(9);  // burada istediğimiz row a direk gidiyoruz. şu an 9. row dayız
            System.out.println("absolute(9) = " + resultSet.getString(2));

            resultSet.afterLast();
            */

           // resultSet.beforeFirst();
            //-____________----------------------------------------------------------------------------------------
            // Task; TÜm rowların ilk iki kolununu bir döngüyle alt alta yazdıralım

//            for (int i=1; i<=10; i++){
//                resultSet.next();
//                System.out.println(resultSet.getString(1) + " => " + resultSet.getString(2));
//            }

            // while yapımı
//            while (resultSet.next()){
//                System.out.println(resultSet.getString(1) + " => " + resultSet.getString(2));
//            }
//            System.out.println("while loop finished");

            //-____________----------------------------------------------------------------------------------------

         //   resultSet.next();
         //   System.out.println("mevcut row sırası = " + resultSet.getRow()); // burda mevcut olan row sayısını öğrendik

            // resultSet li iki kod kullanarak toplam row sayısını konsola yazdıralım
          //  resultSet.last();
         //   System.out.println("mevcut row => "+resultSet.getRow());




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }










    }
}
