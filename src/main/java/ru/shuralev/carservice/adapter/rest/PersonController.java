package ru.shuralev.carservice.adapter.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shuralev.carservice.service.PersonService;
import ru.shuralev.carservice.domain.Person;

@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @PostMapping("/person")
    public ResponseEntity<String> addPerson(@RequestBody Person person) {
        try {
            personService.addPerson(person);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        return ResponseEntity.ok("People added");
    }

    @GetMapping("/person-with-cars/{personId}")
    public Person getPersonWithCars(@PathVariable Long personId) {
        return personService.getPersonWithCarsById(personId);
    }
}
