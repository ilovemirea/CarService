package ru.shuralev.carservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.shuralev.carservice.adapter.rest.dto.Statistics;
import ru.shuralev.carservice.domain.Car;
import ru.shuralev.carservice.repository.CarRepository;
import ru.shuralev.carservice.repository.PersonRepository;
import ru.shuralev.carservice.service.StatisticService;

@Component
@RequiredArgsConstructor
public class StatisticServiceImpl implements StatisticService {

    private final CarRepository carRepository;
    private final PersonRepository personRepository;

    @Transactional(readOnly = true)
    @Override
    public Statistics getStatistics() {
        Long countOfPeople = getCountOfPeople();
        Long countOfCars = getCountOfCars();
        Long countOfUniqueVendors = getCountOfUniqueVendors();

        Statistics statistics = new Statistics();
        statistics.setPersonCount(countOfPeople);
        statistics.setCarCount(countOfCars);
        statistics.setUniqueVendorCount(countOfUniqueVendors);

        return statistics;
    }

    // ===================================================================================================================
    // = Implementation
    // ===================================================================================================================

    private Long getCountOfPeople() {
        return (long) personRepository.findAll().size();
    }

    private Long getCountOfCars() {
        return (long) carRepository.findAll().size();
    }

    private Long getCountOfUniqueVendors() {
        return carRepository.findAll()
                .stream()
                .map(Car::getModel)
                .map(model -> model.substring(0, model.indexOf("-")).toLowerCase())
                .distinct()
                .count();
    }
}
