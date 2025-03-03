package com.Flight.service;

import com.Flight.entity.Airline;

import java.util.List;

public interface AirlineService {
    List<Airline> getAllAirlines();
    Airline getAirlineById(Integer id);
    Airline createAirline(Airline airline);
    Airline updateAirline(Airline airline);
    void deleteAirline(Integer id);
}
