package com.patika.orderservice.model;


import com.patika.orderservice.model.enums.CategoryType;

public class Product {
    //Ürünün kategorisi, fiyatı, ismi ve stok bilgisi vardır.
    int id;
    String name;
    CategoryType category;
    double price;
    int stock;

    public Product(String name, CategoryType category, double price, int stock) {
        this.id = 0;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }
    public Product(int id, String name, CategoryType category, double price, int stock) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    public Product() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(CategoryType category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CategoryType getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}
