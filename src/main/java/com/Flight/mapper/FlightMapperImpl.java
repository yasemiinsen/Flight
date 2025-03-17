package com.Flight.mapper;

import com.Flight.dto.FlightDto;
import com.Flight.entity.Airline;
import com.Flight.entity.Airport;
import com.Flight.entity.Flight;
import org.springframework.stereotype.Component;

@Component
public class FlightMapperImpl implements FlightMapper {

    @Override
    public FlightDto toDto(Flight flight) {
        FlightDto flightDto = new FlightDto();
        flightDto.setFlightId(flight.getFlightId());
        flightDto.setAirlineId(flight.getAirline().getAirlineId());
        flightDto.setSource(flight.getSource().getAirportCode());
        flightDto.setDestination(flight.getDestination().getAirportCode());
        flightDto.setDepartureDate(flight.getDepartureDate());
        flightDto.setArrivalDate(flight.getArrivalDate());
        flightDto.setFlightNumber(flight.getFlightNumber());
        return flightDto;
    }

    @Override
    public Flight toEntity(FlightDto flightDto) {
        Flight flight = new Flight();
        flight.setAirline(new Airline());
        flight.getAirline().setAirlineId(flightDto.getAirlineId());
        flight.setSource(new Airport());
        flight.getSource().setAirportCode(flightDto.getSource());
        flight.setDestination(new Airport());
        flight.getDestination().setAirportCode(flightDto.getDestination());
        flight.setDepartureDate(flightDto.getDepartureDate());
        flight.setArrivalDate(flightDto.getArrivalDate());
        flight.setFlightNumber(flightDto.getFlightNumber());
        return flight;
    }
}
