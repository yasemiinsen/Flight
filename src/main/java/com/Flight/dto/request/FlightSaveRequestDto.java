package com.Flight.dto.request;

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
public class FlightSaveRequestDto {

    private String number;
    private int airlineId;
/*
    private Airport airport;
*/
    @NotNull(message = "Flight time is required")
    @Future(message = "Flight time must be in the future")
    private LocalDateTime dateTime;
    // ekledim
    private int destinationAirportId;
    private int sourceAirportId;


}