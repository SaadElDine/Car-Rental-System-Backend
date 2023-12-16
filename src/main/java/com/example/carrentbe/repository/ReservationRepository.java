package com.example.carrentbe.repository;

import com.example.carrentbe.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    // Custom query methods
}
