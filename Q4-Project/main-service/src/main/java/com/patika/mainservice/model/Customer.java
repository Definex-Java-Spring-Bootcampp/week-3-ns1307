package com.patika.mainservice.model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer extends User {

    //Bir müşteri birden fazla sipariş verebilir.
    List<Order> orderList;
    int id;

    public Customer( String name, String surname, LocalDate birthDate, String email, String password, String phoneNumber, Boolean isActive) {
        super(name, surname, birthDate, email, password, phoneNumber, isActive);
        this.orderList= new ArrayList<Order>();
    }
    public Customer(List<Order> orderList, String name, String surname, LocalDate birthDate, String email, String password, String phoneNumber, Boolean isActive) {
        super(name, surname, birthDate, email, password, phoneNumber, isActive);
        this.orderList=orderList;
        this.id=0;
    }

    public Customer(String name, String surname, LocalDate birthDate, String email, String password, String phoneNumber, Boolean isActive, List<Order> orderList) {
        super(name, surname, birthDate, email, password, phoneNumber, isActive);
        this.orderList = orderList;
        this.id = id;
    }

    public void addNewOrder(Order newOrder){
        orderList.add(newOrder);
    }



    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public int getId() {
        return id;
    }
}
