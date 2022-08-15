package ru.shuralev.carservice.app.api.car;

import ru.shuralev.carservice.domain.car.Car;

public interface CreateCar {
    void execute(Car car);
}
