package com.Flight.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flightId;
    private String flightNumber;
    private String destination;
    private String airlineCode;
    private String source;
    private LocalDateTime departureTime;
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
