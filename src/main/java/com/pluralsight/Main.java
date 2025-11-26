package com.pluralsight;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static String username = "root";
    private static String password = "yearup24";
    private static String databaseUrl = "jdbc:mysql://localhost:3306/northwind";


    //menu
    public static void main(String[] args) {
        String menu = """ 
                  What do you want to do?
                1) Display all products
                2) Display all customers
                0) Exit
                
                """;
        try {
            while (true) {
                System.out.println(menu);
                int option = ConsoleHelper.promptForInt("Enter option");
                switch (option) {
                    case 1:
                        displayProducts();
                        break;
                    case 2:
                      displayCustomers();
                        break;
                    case 0:
                        System.out.println("Goodbye");
                        return;
                    default:
                        System.out.println("Invalid option try again");

                }
            }
        } catch (Exception e) {
            System.out.println("An error happened:" + e.getMessage());
        }
    }


    //split into 2
    public static List<Product> getProducts() throws SQLException, ClassNotFoundException {

        ArrayList<Product> products = new ArrayList<>();

        // load the MySQL Driver
        Class.forName("com.mysql.cj.jdbc.Driver");


        String query = "select ProductID, ProductName, UnitPrice, UnitsInStock from Products";

        try (Connection connection = DriverManager.getConnection(databaseUrl, username, password);
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(query);
        ) {
            while (result.next()) {
                int ProductID = result.getInt("ProductID");
                String ProductName = result.getString("ProductName");
                double UnitPrice = result.getDouble("UnitPrice");
                int UnitsInStock = result.getInt("UnitsInStock");
                Product p = new Product(ProductID, ProductName, UnitPrice, UnitsInStock);
                products.add(p);
            }
        }
        return products;

    }

    // display products
    public static void displayProducts() {
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
    }



public static List<Customer> getCustomers() throws SQLException,ClassNotFoundException {
        ArrayList<Customer> customers = new ArrayList<>();

        //load the MySQL Driver
    Class.forName("com.mysql.cj.jdbc.Driver");
    String query = "select ContactName,CompanyName, City, Country,Phone from Customers";

    try (Connection connection = DriverManager.getConnection(databaseUrl, username, password);
         Statement statement = connection.createStatement();
         ResultSet result = statement.executeQuery(query);
    )
    {
        while (result.next()) {
            String contactName = result.getString("ContactName");
            String companyName = result.getString("CompanyName");
            String city = result.getString("City");
            String country = result.getString("Country");
            String phone = result.getString("Phone");
            Customer c = new Customer(contactName,companyName,city,country,phone);
            customers.add(c);
        }

    }
    return customers;
}

public static void displayCustomers(){

    try {
        List<Customer> myCustomers = getCustomers();

        for (Customer c : myCustomers) {
            System.out.println(c);
        }

    } catch (ClassNotFoundException e) {
        System.out.println("There was a problem loading the driver: " + e.getMessage());
    } catch (SQLException e) {
        System.out.println("There was a problem with the database: " + e.getMessage());
    } catch (Exception e) {
        System.out.println("There was a general error:" + e.getMessage());

    }

}


}







