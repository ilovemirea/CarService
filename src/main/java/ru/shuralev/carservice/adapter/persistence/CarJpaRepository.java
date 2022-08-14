package ru.shuralev.carservice.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shuralev.carservice.domain.Car;

public interface CarJpaRepository extends JpaRepository<Car, Long> {

}