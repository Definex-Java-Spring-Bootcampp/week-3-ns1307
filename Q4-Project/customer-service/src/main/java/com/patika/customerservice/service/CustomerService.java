package com.patika.customerservice.service;

import com.patika.customerservice.model.Order;
import com.patika.customerservice.repo.CustomerRepository;
import org.springframework.stereotype.Service;
import com.patika.customerservice.model.Customer;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private CustomerRepository customerRepository= new CustomerRepository();


    public Customer addNewCustomer(Customer customer){
        return  customerRepository.addNewCustomer(customer);
    }

    public List<Customer> getAll(){
        return customerRepository.getCustomerList();
    }

    public Optional<Customer> getByEmail(String email){
        return customerRepository.findCustomerByEmail(email);
    }

    public Customer addNewOrder(String email, Order order) {
        return customerRepository.addOrder( email,  order);

    }
}
