package com.amazon.jdbc_Test;

import java.sql.*;

public class Test_JDBC_Connection {
    public static void main(String[] args) {

        String url= "jdbc:sqlserver://94.73.170.25:1433;" +  // burası  ip ile portu içerir
                "DatabaseName=u0583688_Kraft2;" + // databasenin ismi
                "encrypt=true;" + // bunu şifreleyerek göndermeyi kabul ediyorum
                "trustServerCertificate=true;"; // database serverinin sertifikalı olduğuna güveniyorum

        String userName="u0583688_Kraft2";
        String password="ANKARA123456789*0987654fg";
        String query="SELECT TOP(10) * FROM u0583688_Kraft2.product.product";



        try {
            Connection connection = DriverManager.getConnection(url,userName,password); //interfacedir. proje ile DataBase yi bağlamak için
            System.out.println("CONNECTİON OK");

            Statement statement = connection.createStatement(); // interfacedir. querynin yazılması ve çalıştırılması için
            ResultSet resultSet = statement.executeQuery(query); // interfacedir. query mize gelen dataların kullanılması için
            resultSet.next(); // 1. satıra geçirir
            System.out.println(resultSet.getString(1)); // 1. satırın 1. sütunünü verir
            System.out.println(resultSet.getString(2)); // 1. satırın 2. sütunünü verir
            System.out.println(resultSet.getString(3)); // 1. satırın 3. sütunünü verir
            resultSet.next(); // 2. satıra geçtik
            System.out.println(resultSet.getString(2)); // 2. satırın 2. sütünü
            resultSet.next(); // 3. satıra geçtik
            System.out.println(resultSet.getString(3)); // 3. satırın 3. kolunu
            resultSet.next(); // 4. satıra geçtik
            System.out.println(resultSet.getString(4)); // 4. satırın 4. sütünü
            resultSet.next(); // ...
            System.out.println(resultSet.getString(5));
            resultSet.next(); // ...
            System.out.println(resultSet.getString(6));


        } catch (SQLException e) {
            System.out.println("CONNECTİON ERROR " + e.getMessage());

        }


    }


}
