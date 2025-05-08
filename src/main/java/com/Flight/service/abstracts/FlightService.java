package com.Flight.service.abstracts;

import com.Flight.entity.Flight;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FlightService {

    Flight save(Flight flight);

    Flight get(int id);

    Flight update(Flight flight);

    boolean delete(int id);





    /*
    *//**
     * Get all flights
     *//*
    List<Flight> getAllFlights();

    *//**
     * Get flight by ID
     *//*
    Optional<Flight> getFlightById(Integer id);

    *//**
     * Create new flight
     * @throws DailyFlightLimitExceededException if airline exceeds daily flight limit
     *//*
    Flight createFlight(Flight flight);

    *//**
     * Update existing flight
     * @throws ResourceNotFoundException if flight not found
     * @throws DailyFlightLimitExceededException if airline exceeds daily flight limit
     *//*
    Flight updateFlight(Flight flight);

    *//**
     * Delete flight by ID
     *//*
    void deleteFlight(Integer id);

    *//**
     * Find flights by route and date range
     *//*
    List<Flight> findFlightsByAirlineAndRoute(Integer airlineId, Integer departureId, 
                                            Integer arrivalId, LocalDateTime startTime, 
                                            LocalDateTime endTime);

    *//**
     * Find flights by cities and date
     *//*
    List<Flight> findFlightsByCities(String departureCity, String arrivalCity, LocalDate date);

    *//**
     * Find flights by airline and date
     *//*
    List<Flight> findFlightsByAirlineAndDate(String airlineCode, LocalDate date);

    *//**
     * Find flights by time range
     *//*
    List<Flight> findFlightsByTimeRange(LocalDateTime startTime, LocalDateTime endTime);*/
}