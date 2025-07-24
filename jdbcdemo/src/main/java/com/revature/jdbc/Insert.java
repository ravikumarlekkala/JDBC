package com.revature.jdbc;

import java.sql.*;

public class Insert {
    public static void insert(String name, String dept, String desig, String email, double salary) {
        Connection connection=null;
        CallableStatement cs=null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqldb","root","Ravi@1704");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        String sql="insert into employee(emp_name,dept,designation,salary,email) values (?,?,?,?,?,?)";
        try {
            cs = connection.prepareCall("{CALL insert_employee(?, ?, ?, ?, ?)}");
            cs.setString(1, name);
            cs.setString(2, dept);
            cs.setString(3, desig);
            cs.setString(4, email);
            cs.setDouble(5, salary);
            cs.execute();

            System.out.println("Insert successful");
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
