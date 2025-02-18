package com.Flight.controller;


import com.Flight.entity.Flight;
import com.Flight.service.FlightService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/api/flights")
@RequiredArgsConstructor

public class FlightController {
    @Autowired
    private final FlightService flightService;



    @PostMapping
    public ResponseEntity<Flight> createFlight(@Valid @RequestBody Flight flight) {
        try {
            Flight createdFlight = flightService.createFlight(flight);
            return new ResponseEntity<>(createdFlight,HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        List<Flight> flights = flightService.getAllFlights();
        return new ResponseEntity<>(flights,HttpStatus.OK);
    }

    @GetMapping("/{flightId}")
    public ResponseEntity<Flight> getFlightId(@PathVariable int flightId) {
        try {
            Flight flight = flightService.getFlightById(flightId);
            return new ResponseEntity<>(flight,HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{flightId}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Integer flightId, @Valid @RequestBody Flight flightDetails) {
        try {
            Flight updatedFlight = flightService.updateFlight(flightId, flightDetails);
            return new ResponseEntity<>(updatedFlight,HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{flightId}")
    public ResponseEntity<Void> deleteFlight(@PathVariable int flightId) {
        try{
            flightService.deleteFlightById(flightId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
