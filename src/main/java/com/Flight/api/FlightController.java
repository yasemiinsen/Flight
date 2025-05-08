package com.Flight.api;

import com.Flight.core.config.modelMapper.IModelMapperService;
import com.Flight.core.result.Result;
import com.Flight.core.result.ResultData;
import com.Flight.core.utilies.ResultHelper;
import com.Flight.dto.response.AirlineResponseDto;
import com.Flight.dto.response.FlightResponseDto;
import com.Flight.dto.request.FlightSaveRequestDto;
import com.Flight.entity.Airline;
import com.Flight.entity.Airport;
import com.Flight.entity.Flight;
import com.Flight.service.abstracts.AirlineService;
import com.Flight.service.abstracts.AirportService;
import com.Flight.service.abstracts.FlightService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/flights")

public class FlightController {
    private final FlightService flightService;
    private final AirlineService airlineService;
    private final AirportService airportService;
    private final IModelMapperService modelMapper;

    public FlightController(FlightService flightService, AirlineService airlineService, AirportService airportService, IModelMapperService modelMapper) {
        this.flightService = flightService;
        this.airlineService = airlineService;
        this.airportService = airportService;
        this.modelMapper = modelMapper;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<FlightResponseDto> save(@Valid @RequestBody FlightSaveRequestDto flightSaveRequestDto) {
        Flight saveFlight = this.modelMapper.forRequest().map(flightSaveRequestDto, Flight.class);

        Airport sourceAirport = this.airportService.get(flightSaveRequestDto.getSourceAirportId());
        saveFlight.setSourceAirport(sourceAirport);

        Airport destinationAirport = this.airportService.get(flightSaveRequestDto.getDestinationAirportId());
        saveFlight.setDestinationAirport(destinationAirport);

        Airline airline = this.airlineService.get(flightSaveRequestDto.getAirlineId());
        saveFlight.setAirline(airline);

        this.flightService.save(saveFlight);
        return ResultHelper.created(this.modelMapper.forResponse().map(saveFlight,FlightResponseDto.class));

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<FlightResponseDto> get(@PathVariable("id") int id){
        Flight flight = this.flightService.get(id);
        return ResultHelper.success(this.modelMapper.forResponse().map(flight, FlightResponseDto.class));
    }

    @GetMapping("/{id}/airline")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AirlineResponseDto> getAirline(@PathVariable("id") int id){
        Flight flight = this.flightService.get(id);
        return ResultHelper.success(this.modelMapper
                .forResponse()
                .map(flight.getAirline(), AirlineResponseDto.class));
    }
    //ekledim
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id){
        this.flightService.delete(id);
        return ResultHelper.ok();
    }













    /*@GetMapping("/flights")
    public List<FlightResponseDto> getAllFlights() {
        log.info("Fetching all airlines");
        return airlineService.getAllAirlines()
                .stream()
                .map(this::convertToDto)  // Fixed: Remove parentheses and parameter
                .collect(Collectors.toList());
    }

    @GetMapping("/{flightId}")
    public ResponseEntity<FlightResponseDto> getFlightById(
            @PathVariable @Min(value = 1, message = "Flight ID must be positive") Integer flightId) {
        log.info("Fetching flight with id: {}", flightId);
        Flight flight = flightService.getFlightById(flightId)
                .orElseThrow(() -> new ResourceNotFoundException("Flight", "id", flightId));
        return ResponseEntity.ok(flightMapper.toDto(flight));
    }

    @PostMapping
    public ResponseEntity<FlightResponseDto> createFlight(@Valid @RequestBody FlightResponseDto flightResponseDto) {
        log.info("Creating new flight with number: {}", flightResponseDto.getFlightNumber());

        var airline = airlineService.getAirlineById(flightResponseDto.getAirlineId());

        var departureAirport = airportService.get(flightResponseDto.getDepartureAirportId());

        var arrivalAirport = airportService.get(flightResponseDto.getArrivalAirportId());

        Flight flight = flightMapper.toEntity(flightResponseDto);
        flight.setAirline(airline);

        Flight createdFlight = flightService.createFlight(flight);
        return ResponseEntity.status(HttpStatus.CREATED).body(flightMapper.toDto(createdFlight));
    }

    @PutMapping("/{flightId}")
    public ResponseEntity<FlightResponseDto> updateFlight(
            @PathVariable @Min(value = 1, message = "Flight ID must be positive") Integer flightId,
            @Valid @RequestBody FlightResponseDto flightResponseDto) {
        log.info("Updating flight with id: {}", flightId);

        // Verify flight exists
        flightService.getFlightById(flightId)
                .orElseThrow(() -> new ResourceNotFoundException("Flight", "id", flightId));

        // Verify airline and airports exist
        airlineService.getAirlineById(flightResponseDto.getAirlineId());
        airportService.get(flightResponseDto.getDepartureAirportId());
        airportService.get(flightResponseDto.getArrivalAirportId());

        Flight flight = flightMapper.toEntity(flightResponseDto);
        flight.setFlightId(flightId);
        Flight updatedFlight = flightService.updateFlight(flight);
        return ResponseEntity.ok(flightMapper.toDto(updatedFlight));
    }

    @DeleteMapping("/{flightId}")
    public ResponseEntity<Void> deleteFlight(
            @PathVariable @Min(value = 1, message = "Flight ID must be positive") Integer flightId) {
        log.info("Deleting flight with id: {}", flightId);

        // Verify flight exists
        flightService.getFlightById(flightId)
                .orElseThrow(() -> new ResourceNotFoundException("Flight", "id", flightId));

        flightService.deleteFlight(flightId);
        return ResponseEntity.noContent().build();
    }*/
}