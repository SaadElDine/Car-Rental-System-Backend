package com.example.carrentbe.controller;

import com.example.carrentbe.DTO.ReservationReportDTO;
import com.example.carrentbe.serviceImplementation.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {
    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/reservations")
    public List<ReservationReportDTO> getAllReservationReports() {
        return reportService.findAllReservationReports();
    }
}
