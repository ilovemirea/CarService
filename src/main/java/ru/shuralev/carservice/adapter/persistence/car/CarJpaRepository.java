package ru.shuralev.carservice.adapter.persistence.car;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shuralev.carservice.model.Car;

public interface CarJpaRepository extends JpaRepository<Car, Long> {

}