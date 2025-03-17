package com.Flight.controller;

import com.Flight.dto.AirportDto;
import com.Flight.entity.Airport;

import com.Flight.service.AirportService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/airports")
@RequiredArgsConstructor
public class AirportController {

    private final AirportService airportService;

    @GetMapping
    public ResponseEntity<List<AirportDto>> getAllAirports() {
        List<Airport> airports = airportService.getAllAirports();
        List<AirportDto> airportDtos = airports.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(airportDtos);
    }

    @GetMapping("/{airportId}")
    public ResponseEntity<AirportDto> getAirportById(@PathVariable Integer airportId) {
        Optional<Airport> airportOpt = airportService.getAirportById(airportId);

        if (airportOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        AirportDto airportDto = convertToDto(airportOpt.get());
        return ResponseEntity.status(HttpStatus.OK).body(airportDto);
    }

    @PostMapping
    public ResponseEntity<AirportDto> createAirport(@RequestBody AirportDto airportDto) {
        Airport airport = convertToEntity(airportDto);
        Airport createdAirport = airportService.createAirport(airport);
        AirportDto createdAirportDto = convertToDto(createdAirport);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAirportDto);
    }

    @PutMapping("/{airportId}")
    public ResponseEntity<AirportDto> updateAirport(@PathVariable Integer airportId, @Valid @RequestBody AirportDto airportDto) {
        Airport airport = convertToEntity(airportDto);
        airport.setAirportId(airportId);
        Airport updatedAirport = airportService.updateAirport(airport);
        AirportDto updatedAirportDto = convertToDto(updatedAirport);
        return ResponseEntity.status(HttpStatus.OK).body(updatedAirportDto);
    }

    @DeleteMapping("/{airportId}")
    public ResponseEntity<Void> deleteAirport(@PathVariable Integer airportId) {
        airportService.deleteAirport(airportId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    private AirportDto convertToDto(Airport airport) {
        AirportDto airportDto = new AirportDto();
        airportDto.setAirportId(airport.getAirportId());
        airportDto.setAirportCode(airport.getAirportCode());
        airportDto.setCity(airport.getCity());
        return airportDto;
    }

    private Airport convertToEntity(AirportDto airportDto) {
        Airport airport = new Airport();
        airport.setAirportCode(airportDto.getAirportCode());
        airport.setCity(airportDto.getCity());
        return airport;
    }
}
