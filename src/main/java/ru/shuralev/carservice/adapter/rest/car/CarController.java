package ru.shuralev.carservice.adapter.rest.car;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shuralev.carservice.app.api.car.CreateCar;
import ru.shuralev.carservice.domain.car.Car;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final CreateCar createCar;

    @PostMapping("/car")
    public ResponseEntity<String> createCar(@RequestBody Car car) {
        try {
            createCar.execute(car);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        return ResponseEntity.ok("Car added");
    }
}
