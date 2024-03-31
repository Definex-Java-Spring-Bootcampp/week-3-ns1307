package com.patika.orderservice.model;

import java.util.ArrayList;
import java.util.List;

public class Order {


    //Bir sipariş içerisinde birden fazla ürün olabilir. (OrderItem)
    //Her siparişin bir faturası vardır.

    double totalPrice;
    List<OrderItem> items;
    Invoice invoice;

    public Order(){
        this.items=new ArrayList<OrderItem>();
        this.invoice=new Invoice();
        totalPrice=0;
    }

    public Order(Invoice invoice) {
        this.totalPrice = totalPrice;
        this.invoice = invoice;
    }

    public Order(List<OrderItem> items, Invoice invoice) {
        this.items = items;
        this.invoice=invoice;
        calculateTotalPrice();
    }

    private void calculateTotalPrice() {
        double total=0;
        for(OrderItem item : items){
            total=total+item.getProduct().getPrice()*item.getCount();
        }
        this.totalPrice=total;
    }

    public void addProduct(Product newProduct, int newCount){
        OrderItem newItem= new OrderItem(newProduct, newCount);
        addItem(newItem);
        totalPrice=totalPrice+newProduct.getPrice()*newCount;
    }
    public void addProduct(Product newProduct){// adds product with 1 count
        addProduct(newProduct,1);

    }
    public void addItem(OrderItem newItem){

        for (OrderItem item : items) {//if item found in items, update its count
            if (item.getProduct().getName().equals(newItem.getProduct().getName())) {
                item.setCount(item.getCount() + newItem.getCount());
                return;
            }
        }
        items.add(newItem);//if item not found in items, add as new OrderItem
    }


    public List<OrderItem> getItems() {
        return items;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

}
