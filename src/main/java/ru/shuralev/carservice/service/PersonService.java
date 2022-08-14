package ru.shuralev.carservice.service;

import ru.shuralev.carservice.domain.Person;

public interface PersonService {
    Person getPersonWithCarsById(Long personId);

    void addPerson(Person person);
}
