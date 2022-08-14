package ru.shuralev.carservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.shuralev.carservice.repository.CarRepository;
import ru.shuralev.carservice.repository.PersonRepository;
import ru.shuralev.carservice.service.CleaningService;

@Component
@RequiredArgsConstructor
public class CleaningServiceImpl implements CleaningService {
    private final CarRepository carRepository;
    private final PersonRepository personRepository;

    @Transactional
    @Override
    public void removeAll() {
        carRepository.deleteAll();
        personRepository.deleteAll();
    }
}
