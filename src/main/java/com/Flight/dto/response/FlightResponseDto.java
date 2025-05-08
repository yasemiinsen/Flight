package com.Flight.dto.response;

import com.Flight.entity.Airline;
import com.Flight.entity.Airport;
import com.Flight.entity.Flight;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightResponseDto {

    private int id;

    private String number;

    private AirlineResponseDto airline;

/*
    private Airport airport;
*/

    private LocalDateTime dateTime;


    //ekledim
    private AirportResponseDto destinationAirport;
    private AirportResponseDto sourceAirport;

}