package ru.shuralev.carservice.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.shuralev.carservice.domain.Person;

public interface PersonJpaRepository extends JpaRepository<Person, Long> {

    @Query(value = "SELECT p.*,c.* FROM person p JOIN car c on p.id = c.owner_id WHERE p.id =: personId",
            nativeQuery = true)
    Person getPersonWithCarsById(@Param("personId") Long personId);
}