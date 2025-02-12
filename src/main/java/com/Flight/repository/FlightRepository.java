package com.Flight.repository;

import com.Flight.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    List<Flight> findByAirlineCodeAndSourceAndDestinationAndDepartureTimeBetween(
            String airlineCode, String source, String destination, LocalDateTime start, LocalDateTime end
    );
}
