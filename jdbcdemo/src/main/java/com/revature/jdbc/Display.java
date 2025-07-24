package com.revature.jdbc;

import java.sql.*;

public class Display {
    public static void display (){
        System.out.println("Statement Demo..");
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqldb","root","Ravi@1704");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        String sql="select * from employee";
        try {
            statement=connection.createStatement();

            resultSet=statement.executeQuery(sql);

            while(resultSet.next()){
                System.out.println(resultSet.getInt(1)+"-" +resultSet.getString(2)+"-" + resultSet.getString(3)+"-" + resultSet.getString(4)+"-" + resultSet.getInt(5)+ "-" + resultSet.getString(6));
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
