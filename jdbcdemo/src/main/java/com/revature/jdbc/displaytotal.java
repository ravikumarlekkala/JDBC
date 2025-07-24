package com.revature.jdbc;

import java.sql.*;

public class displaytotal {
    public static void count() {
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqldb","root","Ravi@1704");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        String sql="select count(*) from employee";
        try {
            statement=connection.createStatement();

            resultSet=statement.executeQuery(sql);

            while(resultSet.next()){
                System.out.println("Total Employees:" + resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
