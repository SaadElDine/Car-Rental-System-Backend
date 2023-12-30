package com.example.carrentbe.repository;

import com.example.carrentbe.DTO.ReservationReportDTO;

import java.util.Date;
import java.util.List;

public interface ReportRepository {
    List<ReservationReportDTO> findAllReservationReports();
    // New method with date range and plateId
    List<ReservationReportDTO> findAllReservationsByCarAndDateRange(String plateId, Date startDate, Date endDate);
}
