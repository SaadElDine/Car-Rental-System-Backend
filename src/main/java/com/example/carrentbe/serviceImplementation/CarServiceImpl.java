package com.example.carrentbe.serviceImplementation;



import com.example.carrentbe.model.Car;
import com.example.carrentbe.repository.CarRepository;
import com.example.carrentbe.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(Integer carId) {
        return carRepository.findById(carId).orElse(null);
    }

    @Override
    public Car updateCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void deleteCar(Integer carId) {
        carRepository.deleteById(carId);
    }
}
