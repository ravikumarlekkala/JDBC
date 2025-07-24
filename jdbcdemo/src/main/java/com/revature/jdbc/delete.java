package com.revature.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class delete {
    public static void Delete(int empid) {

        Connection connection=null;
        PreparedStatement ps=null;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqldb","root","Ravi@1704");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        String sql="delete from employee where emp_id=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1,empid);

            int u= ps.executeUpdate();

            System.out.println("Successfully Deleted");
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
