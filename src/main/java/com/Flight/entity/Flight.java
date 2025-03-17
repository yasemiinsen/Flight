package com.Flight.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flightId;

    @ManyToOne
    @JoinColumn(name = "AirlineId")
    private Airline airline;

    @ManyToOne
    @JoinColumn(name = "SourceAirportId")
    private Airport source;

    @ManyToOne
    @JoinColumn(name = "DestinationAirportId")
    private Airport destination;

    private Date departureDate;
    private Date arrivalDate;
    private Integer flightNumber;


}
