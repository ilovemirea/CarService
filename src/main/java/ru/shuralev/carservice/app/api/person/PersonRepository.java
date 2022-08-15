package ru.shuralev.carservice.app.api.person;

import ru.shuralev.carservice.domain.person.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {
    Optional<Person> findById(Long id);

    List<Person> findAll();

    Person getPersonWithCarsById(Long personId);

    Person save(Person person);

    void deleteAll();

    boolean existsById(Long personId);

}
