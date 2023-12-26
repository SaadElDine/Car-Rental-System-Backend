package com.example.carrentbe.controller;

import com.example.carrentbe.model.Customer;
import com.example.carrentbe.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        // Assume saveCustomer takes care of encrypting password if it's new or has changed.
        Customer createdCustomer = customerService.saveCustomer(customer);
        // Ensure sensitive information like password isn't sent back in the response.
        createdCustomer.setPassword(null);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        // Clear sensitive information before sending.
        customers.forEach(customer -> customer.setPassword(null));
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer != null) {
            customer.setPassword(null); // Ensure password isn't sent back
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        if (!id.equals(customer.getCustomerId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        // Assume updateCustomer takes care of encrypting password if it's new or has changed.
        Customer updatedCustomer = customerService.updateCustomer(customer);
        if (updatedCustomer != null) {
            updatedCustomer.setPassword(null); // Ensure password isn't sent back
            return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
