package com.Flight.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;

import jakarta.validation.constraints.NotNull;


import java.time.LocalDateTime;

@Entity


@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"airlineCode","source","destination","departureTime"}
))
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flightId;


    @NotNull(message= "flightNumber is required" )
    private String flightNumber;

    @NotNull(message = "Destination airport code is required")
    private String destination;

    @NotNull(message= "Airline code is required" )
    private String airlineCode;

    @NotNull(message = "Source airport code is required")
    private String source;

    @NotNull(message = "Departure time is required")
    @Future(message = "Departure time must be in the future")
    private LocalDateTime departureTime;

    @NotNull(message = "Arrival time is required")
    @Future(message = "Arrival time must be in the future")
    private LocalDateTime arrivalTime;


    //Getter Setter methodları

    public Integer getFlightId() {
        return flightId;
    }
    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }
    public String getFlightNumber() {
        return flightNumber;
    }
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = this.flightNumber;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public String getAirlineCode() {return airlineCode;}
    public void setAirlineCode(String airlineCode) {this.airlineCode = airlineCode;}
    public String getSource() {return source;}
    public void setSource(String source) {this.source = source;}
    public LocalDateTime getDepartureTime() {return departureTime;}
    public void setDepartureTime(LocalDateTime departureTime) {this.departureTime = departureTime;}

}
