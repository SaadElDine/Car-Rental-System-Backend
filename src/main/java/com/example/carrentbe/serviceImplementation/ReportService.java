package com.example.carrentbe.serviceImplementation;
import com.example.carrentbe.DTO.ReservationReportDTO;
import com.example.carrentbe.model.Reservation;
import com.example.carrentbe.model.Car;
import com.example.carrentbe.repository.ReservationRepository;
import com.example.carrentbe.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReportService {
    private final ReservationRepository reservationRepository;
    private final CarRepository carsRepository;

    @Autowired
    public ReportService(ReservationRepository reservationRepository, CarRepository carsRepository) {
        this.reservationRepository = reservationRepository;
        this.carsRepository = carsRepository;
    }

    public List<ReservationReportDTO> findAllReservationReports() {
        List<Reservation> reservations = reservationRepository.findAll();
        List<ReservationReportDTO> reports = new ArrayList<>();

        for (Reservation reservation : reservations) {
            // Assuming that reservation.getPlateId() correctly fetches the plateId of the car
            Optional<Car> carOptional = Optional.ofNullable(carsRepository.findbyPlateId(reservation.getPlateId()));
            Car car = carOptional.orElse(null);


            // Create a new DTO object and set reservation and car data into it
            ReservationReportDTO report = new ReservationReportDTO(
                    reservation.getReservationId(),
                    reservation.getCustomerId(),
                    reservation.getPickUpDate(),
                    reservation.getReturnDate(),
                    reservation.getReservationStatus(),
                    car != null ? car.getPlateId() : null,
                    car != null ? car.getColor() : null,
                    car != null ? car.getModel() : null,
                    car != null ? car.getPrice() : null,
                    car != null ? car.getStatus() : null
            );

            reports.add(report);
        }
        return reports;
    }
}
