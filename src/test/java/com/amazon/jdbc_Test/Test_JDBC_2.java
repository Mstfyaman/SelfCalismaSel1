package com.amazon.jdbc_Test;

import java.sql.*;

public class Test_JDBC_2 {
    public static void main(String[] args) {

        String url= "jdbc:sqlserver://94.73.170.25:1433;" +  // burası  ip ile portu içerir
                "DatabaseName=u0583688_Kraft2;" + // databasenin ismi
                "encrypt=true;" + // bunu şifreleyerek göndermeyi kabul ediyorum
                "trustServerCertificate=true;"; // database serverinin sertifikalı olduğuna güveniyorum

        String userName="u0583688_Kraft2";
        String password="ANKARA123456789*0987654fg";
        String query="SELECT TOP(10) * FROM u0583688_Kraft2.product.product";
       // String query="SELECT TOP(10) * FROM u0583688_Kraft2.product.brand";   // burda brand e geçiş yaptık


        try {
            Connection connection = DriverManager.getConnection(url,userName,password);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            System.out.println("resultSet.getString(1) = " + resultSet.getString(2));
         //   System.out.println("Satır Numarası = " + resultSet.getRow());
            System.out.println(resultSet.getRow() +" = " + resultSet.getString(2)); // biraz güzel hali
         //   System.out.println("resultSet.getString(brand_name) = " + resultSet.getString("brand_name")); // samsung  // 16. satırı aktif edince
         //   resultSet.next(); // brand_name içerisinde 2. satıra geçtik
       //     System.out.println("resultSet.getString(brand_name) = " + resultSet.getString("brand_name")); // apple // 16. satırı aktif edince

            int modelyear2 = resultSet.getInt("model_year");  // integer olarak almak istersek
            System.out.println("modelyear2 = " + modelyear2);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
