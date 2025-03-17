package com.Flight.service;

import com.Flight.entity.Flight;

import java.util.List;
import java.util.Optional;

public interface FlightService {
    List<Flight> getAllFlights();
    Optional<Flight> getFlightById(Integer id);
    Flight createFlight(Flight flight);
    Flight updateFlight(Flight flight);
    void deleteFlight(Integer id);
}
