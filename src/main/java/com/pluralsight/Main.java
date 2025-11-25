package com.pluralsight;

import java.sql.*;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static String username = "root";
    String database = "northwind";
    private static String databaseUrl = "jdbc:mysql://localhost:3306/northwind";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        try {
            List<Product> myProducts = getProducts();

            for (Product p : myProducts) {
                System.out.println(p);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("There was a problem loading the driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("There was a problem with the database: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("There was a general error:" + e.getMessage());
        }

        System.out.println("Goodbye!");

    }

    public static List<Product> getProducts() throws SQLException, ClassNotFoundException {

        ArrayList<Product> products = new ArrayList<>();

        // load the MySQL Driver
        Class.forName("com.mysql.cj.jdbc.Driver");


        String query = "select ProductID, ProductName, UnitPrice, UnitsInStock from Products";

        String password = "yearup24";
        try (Connection connection = DriverManager.getConnection(databaseUrl, username, password);
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(query);
        ) {
            while (result.next()) {
                int ProductID = result.getInt("ProductID");
                String ProductName = result.getString("ProductName");
                double UnitPrice = result.getDouble("UnitPrice");
                int UnitsInStock = result.getInt("UnitsInStock");
                Product p = new Product(ProductID,ProductName,UnitPrice,UnitsInStock);
                products.add(p);
            }
        }
        return products ;

    }
//
}




//        // load the MySQL Driver
//        Class.forName("com.mysql.cj.jdbc.Driver");
//// 1. open a connection to the database
//// use the database URL to point to the correct database
//        Connection connection;
//        connection = DriverManager.getConnection(
//                databaseUrl,
//                username,
//                password);
//// create statement
//// the statement is tied to the open connection
//        Statement statement = connection.createStatement();
//// define your query
//       // String countrycode = "USA";
//        //String query = " Select country where countryname = + "" + countrycode + """;
//        // or you can ask the user by iusing a astring and console helper
//
//        String query = "SELECT * FROM Products ";
//// 2. Execute your query
//        ResultSet results = statement.executeQuery(query);
//// process the results
//        while (results.next()) {
//            String productName = results.getString("ProductID","ProductName","UnitPrice", "UnitsInStock");
//            System.out.println(productName);
//        }
//// 3. Close the connection
//        connection.close();
//
//
//
//    }
