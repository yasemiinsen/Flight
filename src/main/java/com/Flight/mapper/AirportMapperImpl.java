package com.Flight.mapper;

import com.Flight.dto.AirportDto;
import com.Flight.entity.Airport;
import com.Flight.mapper.AirportMapper;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class AirportMapperImpl implements AirportMapper {

    @Override
    public AirportDto toDto(Airport airport) {
        if (airport == null) {
            return null;
        }
        AirportDto airportDto = new AirportDto();
        airportDto.setAirportId(airport.getAirportId());
        airportDto.setAirportCode(airport.getAirportCode());
        airportDto.setCity(airport.getCity());
        return airportDto;
    }

    @Override
    public Airport toEntity(AirportDto airportDto) {
        if (airportDto == null) {
            return null;
        }
        Airport airport = new Airport();
        airport.setAirportId(airportDto.getAirportId());
        airport.setAirportCode(airportDto.getAirportCode());
        airport.setCity(airportDto.getCity());
        return airport;
    }
}
