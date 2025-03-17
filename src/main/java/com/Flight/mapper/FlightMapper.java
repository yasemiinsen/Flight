package com.Flight.mapper;

import com.Flight.dto.FlightDto;
import com.Flight.entity.Flight;


public interface FlightMapper {


    FlightDto toDto(Flight flight);


    Flight toEntity(FlightDto flightDto);
}
