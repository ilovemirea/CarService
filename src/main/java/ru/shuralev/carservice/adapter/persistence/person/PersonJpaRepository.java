package ru.shuralev.carservice.adapter.persistence.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.shuralev.carservice.domain.person.Person;

import java.util.Optional;

public interface PersonJpaRepository extends JpaRepository<Person, Long> {

    Optional<Person> findById(Long id);

    @Query(value = "SELECT p.*,c.* FROM person p JOIN car c on p.id = c.owner_id WHERE p.id =:personId",
            nativeQuery = true)
    Person getPersonWithCarsById(@Param("personId") Long personId);
}