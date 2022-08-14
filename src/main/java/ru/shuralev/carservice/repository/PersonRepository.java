package ru.shuralev.carservice.repository;

import ru.shuralev.carservice.domain.Person;

import java.util.List;

public interface PersonRepository {
    List<Person> findAll();

    Person getPersonWithCarsById(Long personId);

    Person save(Person person);

    void deleteAll();

    boolean existsById(Long personId);

}
