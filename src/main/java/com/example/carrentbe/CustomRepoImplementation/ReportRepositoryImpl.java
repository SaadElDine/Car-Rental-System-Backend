package com.example.carrentbe.CustomRepoImplementation;

import com.example.carrentbe.DTO.ReservationReportDTO;
import com.example.carrentbe.repository.ReportRepository;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;

@Repository
public class ReportRepositoryImpl implements ReportRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<ReservationReportDTO> findAllReservationReports() {
        // Assuming you have a JPQL or SQL query that can construct your DTOs
        String jpql = "SELECT new com.example.carrentbe.DTO.ReservationReportDTO(" +
                "r.reservationId, r.customerId, r.pickUpDate, r.returnDate, r.reservationStatus, " +
                "c.plateId, c.color, c.model, c.price, c.status) " +
                "FROM Reservation r LEFT JOIN Car c ON r.plateId = c.plateId";
        Query query = entityManager.createQuery(jpql, ReservationReportDTO.class);
        return query.getResultList();
    }
}
