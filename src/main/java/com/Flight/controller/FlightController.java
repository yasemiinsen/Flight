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
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        try {
            Flight createdFlight = flightService.createFlight(flight);
            return new ResponseEntity<>(createdFlight, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/{flightId}")
    public ResponseEntity<Flight> getFlightId(@PathVariable Integer flightId) {
        try {
            Flight flight = flightService.getFlightById(flightId)
                    .orElseThrow(() -> new IllegalArgumentException("Flight not found"));
            return ResponseEntity.ok(flight);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{flightId}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Integer flightId, @RequestBody Flight flightDetails) {
        try {
            return ResponseEntity.ok(flightService.updateFlight(flightId, flightDetails));
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{flightId}")
    public ResponseEntity<Flight> deleteFlight(@PathVariable Integer flightId) {
        flightService.deleteFlightById(flightId);
        return ResponseEntity.noContent().build();
    }
}
