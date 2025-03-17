package com.Flight.controller;

import com.Flight.dto.AirlineDto;
import com.Flight.entity.Airline;
import com.Flight.service.AirlineService;
import com.Flight.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/airlines")
@RequiredArgsConstructor
@Validated
public class AirlineController {

    private final AirlineService airlineService;

    @GetMapping
    public ResponseEntity<List<AirlineDto>> getAllAirlines() {
        log.info("Fetching all airlines");
        List<Airline> airlines = airlineService.getAllAirlines();
        List<AirlineDto> airlineDtos = airlines.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(airlineDtos);
    }

    @GetMapping("/{airlineId}")
    public ResponseEntity<AirlineDto> getAirlineById(
            @PathVariable @Min(value = 1, message = "Airline ID must be positive") Integer airlineId) {
        log.info("Fetching airline with id: {}", airlineId);
        Airline airline = airlineService.getAirlineById(airlineId);
        return ResponseEntity.ok(convertToDto(airline));
    }

    @PostMapping
    public ResponseEntity<AirlineDto> createAirline(@Valid @RequestBody AirlineDto airlineDto) {
        log.info("Creating new airline with code: {}", airlineDto.getAirlineCode());
        Airline airline = convertToEntity(airlineDto);
        Airline createdAirline = airlineService.createAirline(airline);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(convertToDto(createdAirline));
    }

    @PutMapping("/{airlineId}")
    public ResponseEntity<AirlineDto> updateAirline(
            @PathVariable @Min(value = 1, message = "Airline ID must be positive") Integer airlineId,
            @Valid @RequestBody AirlineDto airlineDto) {
        log.info("Updating airline with id: {}", airlineId);
        
        // Verify airline exists
        airlineService.getAirlineById(airlineId);
        
        Airline airline = convertToEntity(airlineDto);
        airline.setAirlineId(airlineId);
        Airline updatedAirline = airlineService.updateAirline(airline);
        return ResponseEntity.ok(convertToDto(updatedAirline));
    }

    @DeleteMapping("/{airlineId}")
    public ResponseEntity<Void> deleteAirline(
            @PathVariable @Min(value = 1, message = "Airline ID must be positive") Integer airlineId) {
        log.info("Deleting airline with id: {}", airlineId);
        
        // Verify airline exists before deletion
        airlineService.getAirlineById(airlineId);
        airlineService.deleteAirline(airlineId);
        
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/code/{airlineCode}")
    public ResponseEntity<AirlineDto> getAirlineByCode(@PathVariable String airlineCode) {
        log.info("Fetching airline with code: {}", airlineCode);
        Airline airline = airlineService.findByAirlineCode(airlineCode)
                .orElseThrow(() -> new ResourceNotFoundException("Airline", "code", airlineCode));
        return ResponseEntity.ok(convertToDto(airline));
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