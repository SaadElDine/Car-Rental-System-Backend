package com.example.carrentbe.serviceImplementation;

import com.example.carrentbe.DTO.ReservationReportDTO;
import com.example.carrentbe.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReportService {
    private final ReportRepository reportRepository;
    public List<ReservationReportDTO> findAllReservationsByCarAndDateRange(String plateId, Date startDate, Date endDate) {
        return reportRepository.findAllReservationsByCarAndDateRange(plateId, startDate, endDate);
    }

    @Autowired
    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public List<ReservationReportDTO> findAllReservationReports() {
        // Use the ReportRepository to fetch all report data
        return reportRepository.findAllReservationReports();
    }
}
