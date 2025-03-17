package com.Flight.dto;

import lombok.Data;

import java.util.Date;

@Data
public class FlightDto {


    private Integer flightId;
    private Integer airlineId;
    private String source;
    private String destination;
    private Date departureDate;
    private Date arrivalDate;
    private int flightNumber;
}
