package com.example.carrentbe.controller;

import com.example.carrentbe.model.Car;

import com.example.carrentbe.Mapping.SearchRequest;
import com.example.carrentbe.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/search")
    public ResponseEntity<List<Car>> searchCars(@RequestBody SearchRequest request) {
        List<Car> cars = carService.searchCarsBySpecifications(request.getPlateId(), request.getModel(), request.getYear(), request.getPrice());
        return ResponseEntity.ok(cars);
    }@PostMapping("/addcar")
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        System.out.println(car);
        carService.saveCar(car);
        return new ResponseEntity<>(car, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarByPlateId(@PathVariable Integer id) {
        Car car = carService.getCarByPlateId(id);
        return car != null ? ResponseEntity.ok(car) : ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<Car> updateCar(@RequestBody Car car) {
        return ResponseEntity.ok(carService.updateCar(car));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable Integer id) {
        carService.deleteCar(id);
        return ResponseEntity.ok().build();
    }
}