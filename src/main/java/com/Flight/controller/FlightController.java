package com.Flight.controller;

import com.Flight.dto.FlightDto;
import com.Flight.entity.Flight;
import com.Flight.mapper.FlightMapper;
import com.Flight.service.AirlineService;
import com.Flight.service.AirportService;
import com.Flight.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;
    private final AirlineService airlineService;
    private final AirportService airportService;
    private final FlightMapper flightMapper;

    @GetMapping
    public ResponseEntity<List<FlightDto>> getAllFlights() {
        List<Flight> flights = flightService.getAllFlights();
        List<FlightDto> flightDtos = flights.stream()
                .map(flightMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(flightDtos);
    }

    @GetMapping("/{flightId}")
    public ResponseEntity<FlightDto> getFlightById(@PathVariable Integer flightId) {
        Optional<Flight> flight = flightService.getFlightById(flightId);
        FlightDto flightDto = flightMapper.toDto(flight.orElse(null));
        return ResponseEntity.status(HttpStatus.OK).body(flightDto);
    }

    @PostMapping
    public ResponseEntity<FlightDto> createFlight(@RequestBody FlightDto flightDto) {
        Flight flight = flightMapper.toEntity(flightDto);
        Flight createdFlight = flightService.createFlight(flight);
        FlightDto createdFlightDto = flightMapper.toDto(createdFlight);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFlightDto);
    }

    @PutMapping("/{flightId}")
    public ResponseEntity<FlightDto> updateFlight(@PathVariable Integer flightId, @RequestBody FlightDto flightDto) {
        Flight flight = flightMapper.toEntity(flightDto);
        flight.setFlightId(flightId);
        Flight updatedFlight = flightService.updateFlight(flight);
        FlightDto updatedFlightDto = flightMapper.toDto(updatedFlight);
        return ResponseEntity.status(HttpStatus.OK).body(updatedFlightDto);
    }

    @DeleteMapping("/{flightId}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Integer flightId) {
        flightService.deleteFlight(flightId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
