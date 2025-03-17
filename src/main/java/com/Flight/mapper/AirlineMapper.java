package com.Flight.mapper;

import com.Flight.dto.AirlineDto;
import com.Flight.entity.Airline;
import org.mapstruct.Mapper;


public interface AirlineMapper {
    AirlineDto toDto(Airline airline);
    Airline toEntity(AirlineDto airlineDto);
}
