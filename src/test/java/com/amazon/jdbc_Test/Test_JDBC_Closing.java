package com.amazon.jdbc_Test;

import java.sql.*;

public class Test_JDBC_Closing {
    public static void main(String[] args)  {

        String url= "jdbc:sqlserver://94.73.170.25:1433;" +  // burası  ip ile portu içerir
                "DatabaseName=u0583688_Kraft2;" + // databasenin ismi
                "encrypt=true;" + // bunu şifreleyerek göndermeyi kabul ediyorum
                "trustServerCertificate=true;"; // database serverinin sertifikalı olduğuna güveniyorum

        String userName="u0583688_Kraft2";
        String password="ANKARA123456789*0987654fg";
        String query="SELECT TOP(10) * FROM u0583688_Kraft2.product.brand";


        /*

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet =null;


        try {
            connection = DriverManager.getConnection(url,userName,password);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(query);
            resultSet.next();
            System.out.println(resultSet.getString(2));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

         */
// _______________________________üstte try-catch bloğunun bir tür kullanımını gördük_______________


        // burda try-catch bloğunun 2. yolunu görüyoruz

        try ( Connection  connection = DriverManager.getConnection(url,userName,password);
              Statement   statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
              ResultSet resultSet = statement.executeQuery(query);
                )
        {
            resultSet.next();
            System.out.println(resultSet.getString(2));

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Connection  kapandı");


    }
}
