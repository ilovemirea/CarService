package ru.shuralev.carservice.adapter.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shuralev.carservice.app.api.DeleteAllPeopleAndCars;

@RestController
@RequiredArgsConstructor
public class RootController {
    private final DeleteAllPeopleAndCars deleteAllPeopleAndCars;

    @GetMapping("/clear")
    public ResponseEntity<String> deleteAllPeopleAndCars() {
        deleteAllPeopleAndCars.execute();
        return ResponseEntity.ok("All persons and cars were removed");
    }
}
