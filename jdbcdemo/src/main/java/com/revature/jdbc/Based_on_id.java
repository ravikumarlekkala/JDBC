package com.revature.jdbc;

import java.sql.*;
import java.util.Scanner;

public class Based_on_id {
    public static void id(int empid){

        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqldb","root","Ravi@1704");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        String sql="select * from employee where emp_id=?";

        try {
            preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setInt(1,empid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            resultSet=preparedStatement.executeQuery();

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
