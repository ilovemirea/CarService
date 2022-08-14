package ru.shuralev.carservice.adapter.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.shuralev.carservice.domain.Person;
import ru.shuralev.carservice.repository.PersonRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PersonJpaRepositoryAdapter implements PersonRepository {
    private final PersonJpaRepository personJpaRepository;

    @Override
    public List<Person> findAll() {
        return personJpaRepository.findAll();
    }

    @Override
    public Person getPersonWithCarsById(Long personId) {
        return personJpaRepository.getPersonWithCarsById(personId);
    }

    @Override
    public Person save(Person person) {
        return personJpaRepository.save(person);
    }

    @Override
    public void deleteAll() {
        personJpaRepository.deleteAllInBatch();
    }

    @Override
    public boolean existsById(Long personId) {
        return personJpaRepository.existsById(personId);
    }
}
