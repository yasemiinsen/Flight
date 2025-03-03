package com.Flight.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class AirportDto {
    private Long airportId;
    private String airportCode;
    private String city;
}
