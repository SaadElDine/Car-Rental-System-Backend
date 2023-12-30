package com.example.carrentbe.repository;

import com.example.carrentbe.DTO.ReservationReportDTO;
import java.util.List;

public interface ReportRepository {
    List<ReservationReportDTO> findAllReservationReports();
}
