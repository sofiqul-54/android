package com.sofiqul54.sqlightexm;

public class Product {
    private int id;
    private String productName;
    private int quantity;

    public Product() {
    }

    public Product(String productName, int quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

    public Product(int id, String productName, int quantity) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
