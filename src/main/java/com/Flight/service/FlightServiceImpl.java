package com.Flight.service.impl;

import com.Flight.constraints.FlightConstants;
import com.Flight.entity.Flight;
import com.Flight.exception.FlightNotFoundException;
import com.Flight.repository.FlightRepository;
import com.Flight.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public Flight getFlightById(Integer id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new FlightNotFoundException(String.format(FlightConstants.FLIGHT_NOT_FOUND_MESSAGE, id)));
    }

    @Override
    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Flight updateFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public void deleteFlight(Integer id) {
        flightRepository.deleteById(id);
    }
}
