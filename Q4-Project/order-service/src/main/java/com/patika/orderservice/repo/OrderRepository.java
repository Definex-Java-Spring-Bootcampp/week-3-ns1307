package com.patika.orderservice.repo;

import com.patika.orderservice.model.Order;
import com.patika.orderservice.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRepository {

    public List<Order> getOrderList() {
        return orderList;
    }

    private List<Order> orderList = new ArrayList<Order>();

    public void addNewOrder(Order order) {
        orderList.add(order);
    }

    public Order addProduct(int invoiceID, Product product) {
        return addProduct(invoiceID,product,1);
    }
    public Order addProduct(int invoiceID, Product product,int quantity) {
        Order order= orderList.stream()
                .filter(foundOrder -> foundOrder.getInvoice().getInvoiceNo() == invoiceID)
                .findFirst().orElse(null);
        order.addProduct(product,quantity);
        return order;
    }

    public Optional<Order> getOrderByinvoiceNo(int invoiceNo) {
        return orderList.stream()
                .filter(foundOrder -> foundOrder.getInvoice().getInvoiceNo() == invoiceNo)
                .findFirst();
    }
}
