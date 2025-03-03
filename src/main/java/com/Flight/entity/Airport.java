package com.Flight.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @NotNull(message = "Airport")
    @Column(name = "AirportId")
    private Integer airportId;

    @NotNull(message = "Airport name is required")
    @Column(name = "AirportName")
    private String airportName;

    @NotNull(message = "Airport code is required")
    @Column(name = "AirportCode")
    private String airportCode;


    @NotNull(message = "City is required")
    @Column(name = "City")
    private String city;

    @OneToMany(mappedBy = "source", cascade= CascadeType.ALL,orphanRemoval = true)
    private Set<Flight> sourceFlights = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "AirlineId")
    private Airline airline;



}
