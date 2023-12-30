package com.example.carrentbe.repository;

import com.example.carrentbe.model.Car;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cars (plateid, color, imageUrl, location, model, price, status, year) " +
            "VALUES (:#{#car.plateId}, :#{#car.color}, :#{#car.imageUrl}, :#{#car.location}, " +
            ":#{#car.model}, :#{#car.price}, :#{#car.status}, :#{#car.year})", nativeQuery = true)
    void insertCar(@Param("car") Car car);

    @Query(value = "SELECT * FROM cars WHERE plateid = :plateId", nativeQuery = true)
    Car findbyPlateId(@Param("plateId") String plateId);

    @Query(value = "SELECT * FROM Cars c WHERE " +
            "(:plateId IS null or :plateId='' or c.plateId = :plateId) AND" +
            "(:model IS null  or :model='' or c.model = :model) AND " +
            "(:year=0 OR c.year = :year) AND " +
            "(:maxPrice=0.0 OR c.price <= :maxPrice)",
            nativeQuery = true)

        List<Car> searchCarsBySpecifications(
                @Param("plateId") String plateId,
                @Param("model") String model,
                @Param("year") Integer year,
                @Param("maxPrice") Double maxPrice);

}

