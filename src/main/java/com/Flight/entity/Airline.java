package com.Flight.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "airline")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data


public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AirlineId")
    private Integer airlineId;


    @NotNull(message = "Airline name is required")
    @Column(name = "AirlineName")
    private String airlineName;

    @NotNull(message = "Airline code is required")
    @Column(name = "AirlineCode")
    private String airlineCode;

    @NotNull(message = "Country of origin is required")
    @Column(name = "CountryOfOrigin")
    private String countryOfOrigin;

    @OneToMany(mappedBy = "airline", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Flight> flights = new HashSet<>();
}
