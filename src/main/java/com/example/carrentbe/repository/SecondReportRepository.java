/*package com.example.carrentbe.repository;

import com.example.carrentbe.DTO.CarReservationReportDTO;
import com.example.carrentbe.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface SecondReportRepository extends JpaRepository<Reservation, Long> {
    @Query("SELECT new com.example.carrentbe.DTO.CarReservationReportDTO(" +
            "c.plateId, c.model, c.color, c.location, c.year, r.reservationId, r.pickUpDate, r.returnDate, r.reservationStatus) " +
            "FROM Reservation r " +
            "JOIN r.car c " + // Corrected this line
            "WHERE c.plateId = :plateId AND " +
            "r.pickUpDate <= :endDate AND r.returnDate >= :startDate")
    List<CarReservationReportDTO> findAllReservationsByCarInPeriod(
            @Param("plateId") String plateId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);

}
*/