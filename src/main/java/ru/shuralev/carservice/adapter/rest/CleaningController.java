package ru.shuralev.carservice.adapter.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shuralev.carservice.service.CleaningService;

@RestController
@RequiredArgsConstructor
public class CleaningController {
    private final CleaningService cleaningService;

    @GetMapping("/clear")
    public ResponseEntity<String> deleteAll() {
        cleaningService.removeAll();
        return ResponseEntity.ok("All persons and cars were removed");
    }
}
