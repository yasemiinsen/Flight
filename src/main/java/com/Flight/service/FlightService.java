package com.Flight.service;


import com.Flight.entity.Flight;
import com.Flight.exception.FlightNotFoundException;
import com.Flight.exception.GlobalExceptionHandler;
import com.Flight.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);

    }
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
    public Optional<Flight> getFlightById(int id) {
        return flightRepository.findById(id);
    }
    public Flight updateFlight(Integer id, Flight flightDetails) {
        if (flightDetails == null){
            throw new IllegalArgumentException("Flight details cannot be null");
        }
        Flight flight = null;
        try {
            flight = flightRepository.findById(id).orElseThrow(()-> new FlightNotFoundException());
        } catch (FlightNotFoundException e) {
            throw new RuntimeException(e);
        }
        flight.setFlightNumber(flightDetails.getFlightNumber());
        flight.setDestination(flightDetails.getDestination());
        return flightRepository.save(flight);
    }
    public void deleteFlightById(Integer id) {
        flightRepository.deleteById(id);
    }

}
