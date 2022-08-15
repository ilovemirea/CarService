package ru.shuralev.carservice.app.impl.person;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.shuralev.carservice.app.api.person.CreatePerson;
import ru.shuralev.carservice.validation.ValidationException;
import ru.shuralev.carservice.domain.person.Person;
import ru.shuralev.carservice.app.api.person.PersonRepository;
import ru.shuralev.carservice.validation.DateValidator;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class CreatePersonImpl implements CreatePerson {
    private final PersonRepository personRepository;
    private final DateValidator dateValidator;

    @Transactional
    @Override
    public void execute(Person person) {
        LocalDate personBirthdate = person.getBirthdate();
        Long personId = person.getId();

        validatePersonBirthdate(personBirthdate);
        validatePersonId(personId);

        personRepository.save(person);
    }

    // ===================================================================================================================
    // = Implementation
    // ===================================================================================================================

    private void validatePersonBirthdate(LocalDate personBirthdate) {
        if (!dateValidator.isValidFormat(personBirthdate)) {
            throw new ValidationException("Invalid date format");
        }

        LocalDate currentDate = LocalDate.now();
        if (!personBirthdate.isBefore(currentDate)) {
            throw new ValidationException("Person's birthdate should be in a past");
        }
    }

    private void validatePersonId(Long id) {
        if (personRepository.existsById(id)) {
            throw new ValidationException("Person with this ID already exists");
        }
    }
}
