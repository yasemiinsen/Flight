package com.Flight.mapper;

import com.Flight.dto.AirportDto;
import com.Flight.entity.Airport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AirportMapper {
    AirportDto toDto(Airport airport);
    Airport toEntity(AirportDto airportDto);
}
