package com.example.carrentbe.repository;

import com.example.carrentbe.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    // Custom query methods
}
