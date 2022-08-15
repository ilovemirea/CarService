package ru.shuralev.carservice.app.impl.person;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.shuralev.carservice.domain.person.Person;
import ru.shuralev.carservice.app.api.person.PersonRepository;
import ru.shuralev.carservice.app.api.person.GetPersonWithCarsById;

@Component
@RequiredArgsConstructor
public class GetPersonWithCarsByIdImpl implements GetPersonWithCarsById {
    private final PersonRepository personRepository;

    @Transactional(readOnly = true)
    @Override
    public Person execute(Long personId) {
        return personRepository.getPersonWithCarsById(personId);
    }
}
