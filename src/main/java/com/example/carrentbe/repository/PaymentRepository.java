package com.example.carrentbe.repository;
import com.example.carrentbe.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    // Custom query methods
}
