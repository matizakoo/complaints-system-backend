package pl.engineer.active.substances.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/date")
public class DateControllerImpl {

    @GetMapping
    public ResponseEntity<?> getDate() {
        return ResponseEntity.ok(LocalDate.now());
    }
}
