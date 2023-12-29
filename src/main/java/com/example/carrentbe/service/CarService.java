package com.example.carrentbe.service;

import com.example.carrentbe.model.Car;
import java.util.List;

public interface CarService {
    List<Car> searchCarsBySpecifications(String plateId, String model, Integer year, Double price);

    void saveCar(Car car); // Make sure new fields are persisted
    List<Car> getAllCars(); // Ensure new fields are included in the returned data
    Car getCarByPlateId(Integer carId); // Ensure new fields are included when fetching a car by ID
    Car updateCar(Car car); // Ensure new fields are updated
    void deleteCar(Integer carId); // Handle deletion, considering any new field implications
}
