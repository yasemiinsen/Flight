package com.Flight.repository;

import com.Flight.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    @Query("SELECT f FROM Flight f WHERE f.airlineCode = :airlineCode " +
            "AND f.source = :source " +
            "AND CAST(f.departureTime AS DATE) = CAST(:departureTime AS DATE)")
    List<Flight> findFlightsByAirlineSourceDestinationAndDay(
            @Param("airlineCode") String airlineCode,
            @Param("source") String source,
            @Param("destination")String destination,
            @Param("departureTime") LocalDateTime departureTime);
}
