package com.Flight.mapper.impl;

import com.Flight.dto.AirlineDto;
import com.Flight.entity.Airline;
import com.Flight.mapper.AirlineMapper;
import org.springframework.stereotype.Component;

@Component
public class AirlineMapperImpl implements AirlineMapper {
    @Override
    public AirlineDto toDto(Airline airline) {
        AirlineDto airlineDto = new AirlineDto();
        airlineDto.setAirlineId(airline.getAirlineId());
        airlineDto.setAirlineCode(airline.getAirlineCode());
        airlineDto.setAirlineName(airline.getAirlineName());
        return airlineDto;
    }

    @Override
    public Airline toEntity(AirlineDto airlineDto) {
        Airline airline = new Airline();
        airline.setAirlineCode(airlineDto.getAirlineCode());
        airline.setAirlineName(airlineDto.getAirlineName());
        return airline;
    }
}
