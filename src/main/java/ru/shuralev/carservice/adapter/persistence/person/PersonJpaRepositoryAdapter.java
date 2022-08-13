package ru.shuralev.carservice.adapter.persistence.person;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.shuralev.carservice.model.Person;
import ru.shuralev.carservice.repository.PersonRepository;

@Repository
@RequiredArgsConstructor
public class PersonJpaRepositoryAdapter implements PersonRepository {

    private final PersonJpaRepository personJpaRepository;

    @Override
    public Person save(Person person) {
        return personJpaRepository.save(person);
    }

    @Override
    public void deleteAll() {
        personJpaRepository.deleteAllInBatch();
    }
}
