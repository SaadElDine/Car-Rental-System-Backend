package com.example.carrentbe.repository;

import com.example.carrentbe.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    // You can define custom query methods here
}

