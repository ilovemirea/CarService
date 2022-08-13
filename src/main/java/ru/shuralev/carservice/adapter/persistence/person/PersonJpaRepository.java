package ru.shuralev.carservice.adapter.persistence.person;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shuralev.carservice.model.Person;

public interface PersonJpaRepository extends JpaRepository<Person, Long> {

}
