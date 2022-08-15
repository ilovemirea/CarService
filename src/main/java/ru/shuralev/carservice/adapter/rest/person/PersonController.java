package ru.shuralev.carservice.adapter.rest.person;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shuralev.carservice.app.api.person.CreatePerson;
import ru.shuralev.carservice.domain.person.Person;
import ru.shuralev.carservice.app.api.person.GetPersonWithCarsById;

@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class PersonController {
    private final CreatePerson createPerson;
    private final GetPersonWithCarsById getPersonWithCarsById;

    @PostMapping("/person")
    public ResponseEntity<String> createPerson(@RequestBody Person person) {
        try {
            createPerson.execute(person);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        return ResponseEntity.ok("Person added");
    }

    @GetMapping("/person-with-cars/{personId}")
    public Person getPersonWithCars(@PathVariable Long personId) {
        return getPersonWithCarsById.execute(personId);
    }
}
