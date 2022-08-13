package ru.shuralev.carservice.adapter.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shuralev.carservice.model.Car;
import ru.shuralev.carservice.model.Person;
import ru.shuralev.carservice.repository.CarRepository;
import ru.shuralev.carservice.repository.PersonRepository;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CarServiceController {
    private final CarRepository carRepository;
    private final PersonRepository personRepository;


    @PostMapping("/person")
    public ResponseEntity<String> addPerson(@RequestBody Person person){
        try{
            personRepository.save(person);
        }catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        return ResponseEntity.ok("People added");
    }
    @PostMapping("/car")
    public ResponseEntity<String> addCar(@RequestBody Car car){
        try{
            carRepository.save(car);
        }catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        return ResponseEntity.ok("Car added");
    }

}
