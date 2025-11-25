package com.pluralsight;

public class Product {

private int productID;
private String productName;
private double UnitPrice;
private int UnitsInStock;

    public Product(int productID, String productName, double unitPrice, int unitsInStock) {
        this.productID = productID;
        this.productName = productName;
        UnitPrice = unitPrice;
        UnitsInStock = unitsInStock;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        UnitPrice = unitPrice;
    }

    public int getUnitsInStock() {
        return UnitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        UnitsInStock = unitsInStock;
    }

    @Override
    public String toString() {
        return "Products" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", UnitPrice=" + UnitPrice +
                ", UnitsInStock=" + UnitsInStock +
                '}';
    }
}
