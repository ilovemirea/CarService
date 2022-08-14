package ru.shuralev.carservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.shuralev.carservice.service.CarService;
import ru.shuralev.carservice.validation.ValidationException;
import ru.shuralev.carservice.domain.Car;
import ru.shuralev.carservice.repository.CarRepository;
import ru.shuralev.carservice.repository.PersonRepository;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final PersonRepository personRepository;

    @Transactional
    @Override
    public void addCar(Car car) {
        int horsepower = car.getHorsepower();
        Date carOwnerBirthdate = car.getPerson().getBirthdate();
        Long ownerId = car.getPerson().getId();
        Long carId = car.getId();

        validateCarOwnerAge(carOwnerBirthdate);
        validateCarHorsepower(horsepower);
        validateCarOwnerId(ownerId);
        validateCarId(carId);

        carRepository.save(car);
    }

    // ===================================================================================================================
    // = Implementation
    // ===================================================================================================================

    private void validateCarHorsepower(int horsepower) {
        if (horsepower <= 0) {
            throw new ValidationException("Horsepower should be more than 0");
        }
    }

    private void validateCarOwnerAge(Date birthdate) {
        LocalDate currentDate = LocalDate.now();
        LocalDate date = birthdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int carOwnerAge = Period.between(currentDate, date).getYears();

        if (carOwnerAge < 18) {
            throw new ValidationException("Car owner should be older than 18");
        }
    }

    private void validateCarOwnerId(Long id) {
        if (!personRepository.existsById(id)) {
            throw new ValidationException("Owner should be exists");
        }
    }

    private void validateCarId(Long id) {
        if (carRepository.existsById(id)) {
            throw new ValidationException("Car with this ID already exists");
        }
    }
}