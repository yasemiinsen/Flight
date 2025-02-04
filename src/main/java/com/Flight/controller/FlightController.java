package com.Flight.controller;


import com.Flight.entity.Flight;
import com.Flight.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class FlightController {
    @Autowired
    private FlightService flightService;
    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        return new ResponseEntity<>(flightService.createFlight(flight), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightId(@PathVariable Integer id) {
        return flightService.getFlightById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }
    @PutMapping("/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Integer id, @RequestBody Flight flightDetails) {
        Flight updatedFlight = flightService.updateFlight(id, flightDetails);
        return ResponseEntity.ok(updatedFlight);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Flight> deleteFlight(@PathVariable Integer id) {
        flightService.deleteFlightById(id);
        return ResponseEntity.noContent().build();
    }
}
