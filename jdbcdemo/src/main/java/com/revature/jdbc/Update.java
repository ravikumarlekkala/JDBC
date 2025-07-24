package com.revature.jdbc;

import java.sql.*;
import java.util.Scanner;

public class Update {
    public static void update(int eid,String newdesg) {
        Connection connection=null;
        PreparedStatement ps=null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqldb","root","Ravi@1704");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        String sql="update employee set designation=? where emp_id=?";
        try {
            ps = connection.prepareStatement(sql);

            ps.setString(1,newdesg);
            ps.setInt(2,eid);
            int u= ps.executeUpdate();

            System.out.println("Successfully Updated");
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
