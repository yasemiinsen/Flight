package com.Flight.service;

import com.Flight.entity.Airport;

import java.util.List;
import java.util.Optional;

public interface AirportService {
    List<Airport> getAllAirports();
    Optional<Airport> getAirportById(Integer airportId);
    Airport createAirport(Airport airport);
    Airport updateAirport(Airport airport);
    void deleteAirport(Integer id);
}
