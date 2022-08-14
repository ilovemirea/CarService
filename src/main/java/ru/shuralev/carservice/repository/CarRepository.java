package ru.shuralev.carservice.repository;

import ru.shuralev.carservice.domain.Car;

import java.util.List;

public interface CarRepository {

    List<Car> findAll();

    Car save(Car car);

    void deleteAll();

    boolean existsById(Long carId);
}
