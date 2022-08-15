package ru.shuralev.carservice.app.impl.car;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.shuralev.carservice.domain.person.Person;
import ru.shuralev.carservice.app.api.car.CreateCar;
import ru.shuralev.carservice.validation.ValidationException;
import ru.shuralev.carservice.domain.car.Car;
import ru.shuralev.carservice.app.api.car.CarRepository;
import ru.shuralev.carservice.app.api.person.PersonRepository;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
@RequiredArgsConstructor
public class CreateCarImpl implements CreateCar {
    private final CarRepository carRepository;
    private final PersonRepository personRepository;

    @Transactional
    @Override
    public void execute(Car car) {
        Long carId = car.getId();
        Long ownerId = car.getPerson().getId();
        Person carOwner = personRepository.findById(ownerId)
                .orElseThrow(() -> new EntityNotFoundException("Could not find provided Person by id in the database"));
        LocalDate carOwnerBirthdate = carOwner.getBirthdate();
        Integer horsepower = car.getHorsepower();

        validateCarOwnerAge(carOwnerBirthdate);
        validateCarHorsepower(horsepower);
        validateCarOwnerId(ownerId);
        validateCarId(carId);

        carRepository.save(car);
    }

    // ===================================================================================================================
    // = Implementation
    // ===================================================================================================================

    private void validateCarHorsepower(Integer horsepower) {
        if (horsepower <= 0) {
            throw new ValidationException("Horsepower should be more than 0");
        }
    }

    private void validateCarOwnerAge(LocalDate birthdate) {
        LocalDate currentDate = LocalDate.now();
        long carOwnerAge = ChronoUnit.YEARS.between(birthdate, currentDate);

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