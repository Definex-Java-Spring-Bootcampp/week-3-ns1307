package com.patika.customerservice.model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer extends User {

    //Bir müşteri birden fazla sipariş verebilir.
    List<Order> orderList;

    public Customer(){
    }

    public Customer( String name, String surname, LocalDate birthDate, String email, String password, String phoneNumber, Boolean isActive) {
        super(name, surname, birthDate, email, password, phoneNumber, isActive);
        this.orderList= new ArrayList<Order>();
    }
    public Customer(List<Order> orderList, String name, String surname, LocalDate birthDate, String email, String password, String phoneNumber, Boolean isActive) {
        super(name, surname, birthDate, email, password, phoneNumber, isActive);
        this.orderList=orderList;

    }

    public Customer(String name, String surname, LocalDate birthDate, String email, String password, String phoneNumber, Boolean isActive, List<Order> orderList) {
        super(name, surname, birthDate, email, password, phoneNumber, isActive);
        this.orderList = orderList;

    }

    public void addNewOrder(Order newOrder){
        orderList.add(newOrder);
    }



    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }


    public List<Order> getOrderList() {
        return orderList;
    }


}
