package ru.shuralev.carservice.repository;

import ru.shuralev.carservice.model.Car;

public interface CarRepository{
    Car save (Car car);

    void deleteAll();
}
