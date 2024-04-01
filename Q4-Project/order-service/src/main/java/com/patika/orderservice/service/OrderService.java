package com.patika.orderservice.service;

import com.patika.orderservice.Producer.RequestProducer;
import com.patika.orderservice.model.Invoice;
import com.patika.orderservice.model.Order;
import com.patika.orderservice.model.Product;
import com.patika.orderservice.repo.OrderRepository;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
@Service
@Scope(value = "singleton")
@RequiredArgsConstructor
public class OrderService {
    private OrderRepository orderRepository = new OrderRepository();

    private final RequestProducer requestProducer;
    public Order createNewOrder(Invoice invoice) {
        requestProducer.sendRequest();
        Order order= new Order(invoice);
        //requestConsumer.getRequest();
        orderRepository.addNewOrder(order);
        return order;
    }

    public List<Order> getAllOrders(){
        return orderRepository.getOrderList();
    }

    public Order addProduct(int invoiceID, Product product) {
        return orderRepository.addProduct(invoiceID,product);
    }

    public Order addProduct(int invoiceID, Product product,int quantity) {
        return orderRepository.addProduct(invoiceID,product,quantity);
    }


    public Optional<Order> getOrderByinvoiceNo(int invoiceNo) {
        return orderRepository.getOrderByinvoiceNo(invoiceNo);
    }
}
