package com.revature.jdbc;

import java.sql.*;
import java.util.Scanner;

public class displaydept {
    public static void countByDept(String dept) {

        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet resultSet=null;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqldb","root","Ravi@1704");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        String sql="select count(*) from employee where dept=?";
        try {
            ps=connection.prepareStatement(sql);
            ps.setString(1,dept);

            resultSet=ps.executeQuery();

            while(resultSet.next()){
                System.out.println("Employees in " + dept + " :"+ resultSet.getInt(1));
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
