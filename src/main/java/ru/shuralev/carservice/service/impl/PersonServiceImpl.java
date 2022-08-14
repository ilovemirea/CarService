package ru.shuralev.carservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.shuralev.carservice.service.PersonService;
import ru.shuralev.carservice.validation.ValidationException;
import ru.shuralev.carservice.domain.Person;
import ru.shuralev.carservice.repository.PersonRepository;
import ru.shuralev.carservice.validation.DateValidator;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final DateValidator dateValidator;

    @Transactional
    @Override
    public void addPerson(Person person) {
        Date personBirthdate = person.getBirthdate();
        Long personId = person.getId();

        validatePersonBirthDate(personBirthdate);
        validatePersonId(personId);

        personRepository.save(person);
    }

    @Transactional(readOnly = true)
    @Override
    public Person getPersonWithCarsById(Long personId) {
        return personRepository.getPersonWithCarsById(personId);
    }

    // ===================================================================================================================
    // = Implementation
    // ===================================================================================================================

    private void validatePersonBirthDate(Date personBirthdate) {
        if (!dateValidator.isValidFormat(personBirthdate)) {
            throw new ValidationException("Invalid date format");
        }
        if (!dateValidator.isDateBeforeCurrent(personBirthdate)) {
            throw new ValidationException("Person's birthdate should be in a past");
        }
    }

    private void validatePersonId(Long id) {
        if (personRepository.existsById(id)) {
            throw new ValidationException("Person with this ID already exists");
        }
    }
}
