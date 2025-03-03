package com.Flight.service;

import com.Flight.entity.Flight;

import java.util.List;

public interface FlightService {
    List<Flight> getAllFlights();
    Flight getFlightById(Integer id);
    Flight createFlight(Flight flight);
    Flight updateFlight(Flight flight);
    void deleteFlight(Integer id);
}
