package com.Flight.repository;

import com.Flight.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    long countByAirlineCodeAndSourceAndDestinationAndDepartureTime(String airlineCode, String sourceAirport, String destinationAirport, LocalDateTime departureTime, LocalDateTime arrivalTime);
}
