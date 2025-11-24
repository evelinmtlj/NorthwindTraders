package com.pluralsight;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String username = "root";
        String password = "yearup24";
        String databaseUrl = "jdbc:mysql://localhost:3306/northwind";




        // load the MySQL Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
// 1. open a connection to the database
// use the database URL to point to the correct database
        Connection connection;
        connection = DriverManager.getConnection(
                databaseUrl,
                username,
                password);
// create statement
// the statement is tied to the open connection
        Statement statement = connection.createStatement();
// define your query
        String query = "SELECT * FROM Products ";
// 2. Execute your query
        ResultSet results = statement.executeQuery(query);
// process the results
        while (results.next()) {
            String productName = results.getString("ProductName");
            System.out.println(productName);
        }
// 3. Close the connection
        connection.close();



    }
}