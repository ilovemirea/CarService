package ru.shuralev.carservice.app.api.person;

import ru.shuralev.carservice.domain.person.Person;

public interface CreatePerson {
    void execute(Person person);
}
