package com.patika.customerservice.repo;

import com.patika.customerservice.model.Customer;
import com.patika.customerservice.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CustomerRepository {

    public List<Customer> customerList= new ArrayList<Customer>();



    public List<Customer> getCustomerList() {
        return customerList;
    }

    public Customer addNewCustomer(Customer customer) {
        customerList.add(customer);
        return customer;
    }

    public Optional<Customer> findCustomerByEmail(String email) {
        return customerList.stream()
                .filter(customer -> Objects.equals(customer.getEmail(), email))
                .findFirst();
    }

    public Customer addOrder(String email, Order order) {
        Customer customer= customerList.stream()
                .filter(foundCustomer -> Objects.equals(foundCustomer.getEmail(), email))
                .findFirst().orElse(null);
        customer.addNewOrder(order);
        return customer;
    }
}
