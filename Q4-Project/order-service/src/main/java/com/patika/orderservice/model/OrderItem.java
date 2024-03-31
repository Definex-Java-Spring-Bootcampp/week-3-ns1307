package com.patika.orderservice.model;

public class OrderItem {
    //OrderItem: Sipariş verilen ürün ve o ürünün adedini içeren obje
    private Product product;
    private int count;
    public OrderItem(Product product, int count) {
        this.product=product;
        this.count=count;
    }



    public void setProduct(Product product) {
        this.product = product;
    }

    public void setCount(int count) {
        this.count = count;
    }



    public Product getProduct() {
        return product;
    }

    public int getCount() {
        return count;
    }

}
