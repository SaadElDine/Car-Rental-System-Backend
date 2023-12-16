package com.example.carrentbe.serviceImplementation;

import com.example.carrentbe.service.CustomerService;


import com.example.carrentbe.model.Customer;
import com.example.carrentbe.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Integer customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            return customer.get();
        } else {
            // You can handle it differently, like throwing a custom exception
            return null;
        }
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        // Check if customer exists before updating
        if (customer != null && customer.getCustomerId() != null && customerRepository.existsById(customer.getCustomerId())) {
            return customerRepository.save(customer);
        } else {
            // Handle the case where the customer doesn't exist
            return null;
        }
    }

    @Override
    public void deleteCustomer(Integer customerId) {
        if (customerRepository.existsById(customerId)) {
            customerRepository.deleteById(customerId);
        } else {
            // Handle the case where the customer doesn't exist or log this event
        }
    }
}
