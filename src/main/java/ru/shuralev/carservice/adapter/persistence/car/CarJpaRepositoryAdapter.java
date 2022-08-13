package ru.shuralev.carservice.adapter.persistence.car;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.shuralev.carservice.model.Car;
import ru.shuralev.carservice.repository.CarRepository;

@Repository
@RequiredArgsConstructor
public class CarJpaRepositoryAdapter implements CarRepository {
    private final CarJpaRepository carJpaRepository;

    @Override
    public Car save(Car car) {
        return carJpaRepository.save(car);
    }

    @Override
    public void deleteAll() {
        carJpaRepository.deleteAllInBatch();
    }
}
