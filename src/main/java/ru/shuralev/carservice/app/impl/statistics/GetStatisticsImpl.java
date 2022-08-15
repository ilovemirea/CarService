package ru.shuralev.carservice.app.impl.statistics;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.shuralev.carservice.adapter.rest.statistics.dto.Statistics;
import ru.shuralev.carservice.domain.car.Car;
import ru.shuralev.carservice.app.api.car.CarRepository;
import ru.shuralev.carservice.app.api.person.PersonRepository;
import ru.shuralev.carservice.app.api.statistics.GetStatistics;

@Component
@RequiredArgsConstructor
public class GetStatisticsImpl implements GetStatistics {

    private final CarRepository carRepository;
    private final PersonRepository personRepository;

    @Transactional(readOnly = true)
    @Override
    public Statistics execute() {
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
