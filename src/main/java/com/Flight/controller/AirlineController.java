package com.Flight.controller;

import com.Flight.dto.AirlineDto;
import com.Flight.entity.Airline;
import com.Flight.service.AirlineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/airlines")
@RequiredArgsConstructor
public class AirlineController {

    private final AirlineService airlineService;

    @GetMapping
    public ResponseEntity<List<AirlineDto>> getAllAirlines() {
        List<Airline> airlines = airlineService.getAllAirlines();
        List<AirlineDto> airlineDtos = airlines.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(airlineDtos);
    }

    @GetMapping("/{airlineId}")
    public ResponseEntity<AirlineDto> getAirlineById(@PathVariable Integer airlineId) {
        Airline airline = airlineService.getAirlineById(airlineId);
        AirlineDto airlineDto = convertToDto(airline);
        return ResponseEntity.status(HttpStatus.OK).body(airlineDto);
    }

    @PostMapping
    public ResponseEntity<AirlineDto> createAirline(@RequestBody AirlineDto airlineDto) {
        Airline airline = convertToEntity(airlineDto);
        Airline createdAirline = airlineService.createAirline(airline);
        AirlineDto createdAirlineDto = convertToDto(createdAirline);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAirlineDto);
    }

    @PutMapping("/{airlineId}")
    public ResponseEntity<AirlineDto> updateAirline(@PathVariable Integer airlineId, @RequestBody AirlineDto airlineDto) {
        Airline airline = convertToEntity(airlineDto);
        airline.setAirlineId(airlineId);
        Airline updatedAirline = airlineService.updateAirline(airline);
        AirlineDto updatedAirlineDto = convertToDto(updatedAirline);
        return ResponseEntity.status(HttpStatus.OK).body(updatedAirlineDto);
    }

    @DeleteMapping("/{airlineId}")
    public ResponseEntity<Void> deleteAirline(@PathVariable Integer airlineId) {
        airlineService.deleteAirline(airlineId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    private AirlineDto convertToDto(Airline airline) {
        AirlineDto airlineDto = new AirlineDto();
        airlineDto.setAirlineId(airline.getAirlineId());
        airlineDto.setAirlineCode(airline.getAirlineCode());
        airlineDto.setAirlineName(airline.getAirlineName());
        return airlineDto;
    }

    private Airline convertToEntity(AirlineDto airlineDto) {
        Airline airline = new Airline();
        airline.setAirlineCode(airlineDto.getAirlineCode());
        airline.setAirlineName(airlineDto.getAirlineName());
        return airline;
    }
}
