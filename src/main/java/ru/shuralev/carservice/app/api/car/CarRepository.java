package ru.shuralev.carservice.app.api.car;

import ru.shuralev.carservice.domain.car.Car;

import java.util.List;

public interface CarRepository {

    List<Car> findAll();

    Car save(Car car);

    void deleteAll();

    boolean existsById(Long carId);
}
