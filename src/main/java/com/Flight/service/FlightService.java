package com.Flight.service;


import com.Flight.entity.Flight;
import com.Flight.repository.FlightRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    @Transactional
    public Flight createFlight(Flight flight) {
        //constraint
        LocalDate flightDate = flight.getDepartureTime().toLocalDate();
        List<Flight> existingFlights = flightRepository.findByAirlineCodeAndSourceAndDestinationAndDepartureTimeBetween(
                flight.getAirlineCode(), flight.getSource(), flight.getDestination(),
                flightDate.atStartOfDay(), flightDate.atTime(23, 59));


        if (existingFlights.size() >= 3) {
            throw new IllegalArgumentException("An airline can only have at most 3 flights per day for the same route.");
        }
        return flightRepository.save(flight);

    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightById(int flightId) {
        return Optional.ofNullable(flightRepository.findById(flightId)
                .orElseThrow(() -> new IllegalArgumentException("Flight not found")));

    }

    @Transactional
    public Flight updateFlight(Integer flightId, Flight flightDetails) {
        Flight flight = getFlightById(flightId);
        flight.setAirlineCode(flightDetails.getAirlineCode());
        flight.setFlightNumber(flightDetails.getFlightNumber());
        flight.setSource(flightDetails.getSource());
        flight.setDestination(flightDetails.getDestination());
        flight.setDepartureTime(flightDetails.getDepartureTime());
        flight.setArrivalTime(flightDetails.getArrivalTime());
        return flightRepository.save(flight);
    }

    @Transactional
    public void deleteFlightById(int flightId) {
        flightRepository.deleteById(flightId);
    }


}
