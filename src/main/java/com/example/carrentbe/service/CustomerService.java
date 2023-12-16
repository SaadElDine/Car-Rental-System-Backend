package com.example.carrentbe.service;


import com.example.carrentbe.model.Customer;
import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer getCustomerById(Integer customerId);
    Customer updateCustomer(Customer customer);
    void deleteCustomer(Integer customerId);
}
