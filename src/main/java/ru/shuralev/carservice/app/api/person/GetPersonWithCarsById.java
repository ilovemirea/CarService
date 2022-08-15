package ru.shuralev.carservice.app.api.person;

import ru.shuralev.carservice.domain.person.Person;

public interface GetPersonWithCarsById {
    Person execute(Long personId);
}
