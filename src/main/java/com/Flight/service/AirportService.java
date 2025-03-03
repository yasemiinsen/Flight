package com.Flight.service;

import com.Flight.entity.Airport;

import java.util.List;

public interface AirportService {
    List<Airport> getAllAirports();
    Airport getAirportById(Integer id);
    Airport createAirport(Airport airport);
    Airport updateAirport(Airport airport);
    void deleteAirport(Integer id);
}
