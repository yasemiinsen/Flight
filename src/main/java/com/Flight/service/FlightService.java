package com.Flight.service;


import com.Flight.entity.Flight;
import com.Flight.repository.FlightRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;

    @Transactional
    public Flight createFlight(Flight flight) {
        // Constraint: Maximum 3 flights per day for the same route and airline
        LocalDate flightDate = flight.getDepartureTime().toLocalDate();
        List<Flight> existingFlights = flightRepository.findFlightsByAirlineSourceDestinationAndDay(
                flight.getAirlineCode(), flight.getSource(), flight.getDestination(), flight.getDepartureTime());

        System.out.println("Existing flights count: " + existingFlights.size());
        System.out.println("Checking for airline: " + flight.getAirlineCode() +
                " | Source: " + flight.getSource() +
                " | Destination: " + flight.getDestination() +
                " | Date: " + flightDate);

        if (existingFlights.size() >= 3) {
            throw new IllegalArgumentException("An airline can only have at most 3 flights per day for the same route.");
        }

        return flightRepository.save(flight);
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightById(int flightId) {
        return flightRepository.findById(flightId)
                .orElseThrow(() -> new IllegalArgumentException("Flight not found"));
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
