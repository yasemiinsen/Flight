package com.Flight.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AirlineDto {
    private Integer airlineId;
    private String airlineCode;
    private String airlineName;
}
