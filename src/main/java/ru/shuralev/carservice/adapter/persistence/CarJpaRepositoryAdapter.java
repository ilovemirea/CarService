package ru.shuralev.carservice.adapter.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.shuralev.carservice.domain.Car;
import ru.shuralev.carservice.repository.CarRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CarJpaRepositoryAdapter implements CarRepository {
    private final CarJpaRepository carJpaRepository;

    @Override
    public List<Car> findAll() {
        return carJpaRepository.findAll();
    }

    @Override
    public Car save(Car car) {
        return carJpaRepository.save(car);
    }

    @Override
    public void deleteAll() {
        carJpaRepository.deleteAllInBatch();
    }

    @Override
    public boolean existsById(Long carId) {
        return carJpaRepository.existsById(carId);
    }
}
