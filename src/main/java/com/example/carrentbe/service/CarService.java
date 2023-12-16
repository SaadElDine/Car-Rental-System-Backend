package com.example.carrentbe.service;

import com.example.carrentbe.model.Car;//yourpackage.model.Car;
import java.util.List;

public interface CarService {
    Car saveCar(Car car);
    List<Car> getAllCars();
    Car getCarById(Integer carId);
    Car updateCar(Car car);
    void deleteCar(Integer carId);
}
