package com.example.shopcartexample;

import lombok.Data;

@Data
public class Product {

    private String name;

    private String category;

    private int quantity;

    private double price;

    public Product(String name, String category, int quantity, double price) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }
}
