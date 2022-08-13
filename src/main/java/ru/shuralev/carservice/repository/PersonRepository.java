package ru.shuralev.carservice.repository;

import ru.shuralev.carservice.model.Person;

public interface PersonRepository{

    Person save(Person person);

    void deleteAll();

}
