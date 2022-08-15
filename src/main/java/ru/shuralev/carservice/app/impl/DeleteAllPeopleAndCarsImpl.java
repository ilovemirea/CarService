package ru.shuralev.carservice.app.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.shuralev.carservice.app.api.car.CarRepository;
import ru.shuralev.carservice.app.api.person.PersonRepository;
import ru.shuralev.carservice.app.api.DeleteAllPeopleAndCars;

@Component
@RequiredArgsConstructor
public class DeleteAllPeopleAndCarsImpl implements DeleteAllPeopleAndCars {
    private final CarRepository carRepository;
    private final PersonRepository personRepository;

    @Transactional
    @Override
    public void execute() {
        carRepository.deleteAll();
        personRepository.deleteAll();
    }
}
